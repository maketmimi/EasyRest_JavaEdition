package core;

import core.events.EnRunningStateChangeReason;
import core.events.IActionListener;
import core.events.IRunningStateChangedListener;
import core.events.ITickListener;
import core.helpers.fileHelpers.FileHelper;
import java.awt.event.ActionEvent;
import java.time.Duration;
import javax.swing.Timer;

public class EasyRestStatus {

    private static final String _RecordSeperator  = "[RestStatus]";

    // fields

    private Timer tickTimer = new Timer(1000, this::Tick);
    private ITickListener _tickListener = null;
    private IActionListener _onPeriodEnd = null;
    private IActionListener _onPeriodSwitch = null;
    private IRunningStateChangedListener _onRunningStateChanged = null;
    
    private long _NumberOfSecondsRemainig;
    private Period _RestPeriod = null;
    private Period _WorkPeriod = null;
    private Period _CurrentPeriod = null; 

    public void setOnPeriodEndListener(IActionListener _onPeriodEnd) {
        this._onPeriodEnd = _onPeriodEnd;
    }

    public void setOnPeriodSwitchListener(IActionListener _onPeriodSwitch) {
        this._onPeriodSwitch = _onPeriodSwitch;
    }
    
    public void setTickListener(ITickListener _tickListener) {
        this._tickListener = _tickListener;
    }

    public void setOnRunningStateChangedListener(IRunningStateChangedListener _onRunningStateChanged) {
        this._onRunningStateChanged = _onRunningStateChanged;
    }
    
    public long getNumberOfSecondsRemainig() {
        return _NumberOfSecondsRemainig;
    }

    private void setNumberOfSecondsRemainig(long NumberOfSecondsRemainig) {
        this._NumberOfSecondsRemainig = NumberOfSecondsRemainig;
    }

    public Period getRestPeriod() {
        return _RestPeriod;
    }

    private void setRestPeriod(Period RestPeriod) {
        
        this._RestPeriod = RestPeriod;
        this._RestPeriod.setOnDurationChangedListener(this::periodDurationChanged);
        
    }

    public Period getWorkPeriod() {
        return _WorkPeriod;
    }

    private void setWorkPeriod(Period WorkPeriod) {

        this._WorkPeriod = WorkPeriod;
        this._WorkPeriod.setOnDurationChangedListener(this::periodDurationChanged);
        
    }

    public Period getCurrentPeriod() {
        return _CurrentPeriod;
    }

    public void setCurrentPeriod(Period CurrentPeriod) {

        if (CurrentPeriod != null && (CurrentPeriod == _RestPeriod || CurrentPeriod == _WorkPeriod)) 
        {
            _CurrentPeriod = CurrentPeriod;
            setNumberOfSecondsRemainig(getCurrentPeriod().getDuration().toSeconds());
        }

    }
    
    // methods & constructors
    
    public EasyRestStatus(boolean isRunning) {
        
        setRestPeriod(new Period("Rest Period", "It is time for work", Duration.ofMinutes(10), Period.EnAlarmType.ScreenOverlay, null));
        setWorkPeriod(new Period("Work Period", "It is time for rest", Duration.ofMinutes(20), Period.EnAlarmType.ScreenOverlay, null));

        setCurrentPeriod(_WorkPeriod);

        if (isRunning)
            Start();
    }

    private EasyRestStatus(Period workPeriod, Period restPeriod) {
        
        setWorkPeriod(workPeriod);
        setRestPeriod(restPeriod);
        
        setCurrentPeriod(_WorkPeriod);
        
        Start();
    }
    
    
    private void periodDurationChanged(Object sender){
        
        if (getCurrentPeriod() == ((Period) sender))
            setNumberOfSecondsRemainig(((Period) sender).getDuration().toSeconds());
        
    }
    
    private void SwitchPeriods() {
        
        if (getCurrentPeriod() == _RestPeriod) 
        {
            setCurrentPeriod(_WorkPeriod);
        } 
        else
        {
            setCurrentPeriod(_RestPeriod);
        }
        
    }

    public void Pause() {

        Pause(EnRunningStateChangeReason.NormalCall);
        
    }

    public void Start() {

        Start(EnRunningStateChangeReason.NormalCall);

    }
    
    private void Start(EnRunningStateChangeReason reason){
        
        tickTimer.start();
        
        if (_onRunningStateChanged != null)
            _onRunningStateChanged.runningStateChanged(this, reason);
        
    }
    
    private void Pause(EnRunningStateChangeReason reason){
        
        tickTimer.stop();
        
        if (_onRunningStateChanged != null)
            _onRunningStateChanged.runningStateChanged(this, reason);

    }
    
    public boolean isRunning()
    {
        return tickTimer.isRunning();
    }
    
    // this returns the String of the remining seconds in Minutes:Seconds format
    public String GetReminingDurationString() 
    {
        int minutes = (int) getNumberOfSecondsRemainig() / 60;
        int seconds = (int) getNumberOfSecondsRemainig() % 60;
        
        return String.format("%02d:%02d", minutes, seconds);
    }

    public String ConvertToStringRecord() {
        return String.join(_RecordSeperator, _WorkPeriod.ConvertToStringRecord(), _RestPeriod.ConvertToStringRecord());
    }

    public static EasyRestStatus ConvertStringRecordToStatusObject(String Record) {
        
        String[] arrRecord = Record.split(_RecordSeperator);

        try 
        {
            Period WorkPeriod = Period.ConvertStringRecordToPeriod(arrRecord[0]);
            Period RestPeriod = Period.ConvertStringRecordToPeriod(arrRecord[1]);

            if (WorkPeriod == null || RestPeriod == null) {
                return null;
            }

            return new EasyRestStatus(WorkPeriod, RestPeriod);
        } 
        catch (Exception any)
        {
            return null;
        }
    }

    private void Tick(ActionEvent e){
        
        setNumberOfSecondsRemainig(_NumberOfSecondsRemainig - 1);

        if (_tickListener != null)
            _tickListener.Tick(this);
        
        if (getNumberOfSecondsRemainig() == 0)
        {
            Pause(EnRunningStateChangeReason.TickCall);
            
            getCurrentPeriod().ShowEndAlarm();
            
            if (_onPeriodEnd != null)
                _onPeriodEnd.actionPerformed(this);
            
            SwitchPeriods();
            
            if (_onPeriodSwitch != null)
                _onPeriodSwitch.actionPerformed(this);
            
            Start(EnRunningStateChangeReason.TickCall);
        }
    }
    
    public void saveToFile(String fileName){
        
        FileHelper.writeRecordToFile(fileName, ConvertToStringRecord());
        
    }
    
    public static EasyRestStatus laodFromFile(String fileName){
        
        return ConvertStringRecordToStatusObject(FileHelper.readRecordFromFile(fileName));
        
    }
    
}

