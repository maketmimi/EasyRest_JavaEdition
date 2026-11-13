package core;

import core.events.EnRunningStateChangeReason;
import core.events.GeneralEvent;
import core.events.IRunningStateChangedListener;
import core.helpers.fileHelpers.FileHelper;
import java.time.Duration;
import core.events.IGeneralListener;
import core.events.RunningStateChangedEvent;
import core.events.RunningStateChangedEventArgs;
import core.events.SimpleEventArgs;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class EasyRestStatus {

    private static final String _RecordSeperator  = "[RestStatus]";

    // fields

    private final Timer _tickTimer = new Timer();
    private boolean _isRunning = false;

    private final GeneralEvent _onNumberOfSecondsRemainingChanged = new GeneralEvent();
    private final GeneralEvent _onCurrentPeriodChanged = new GeneralEvent();
    private final RunningStateChangedEvent _onRunningStateChanged = new RunningStateChangedEvent();
    
    private long _NumberOfSecondsRemainig;
    private Period _RestPeriod = null;
    private Period _WorkPeriod = null;
    private Period _CurrentPeriod = null; 

    public void addOnNumberOfSecondsRemainingChangedListener(IGeneralListener listenerToAdd) {
        _onNumberOfSecondsRemainingChanged.addListener(listenerToAdd);
    }

    public void addOnCurrentPeriodChangedListener(IGeneralListener listenerToAdd) {
        _onCurrentPeriodChanged.addListener(listenerToAdd);
    }
    
    public void addOnRunningStateChangedListener(IRunningStateChangedListener listenerToAdd) {
        _onRunningStateChanged.addListener(listenerToAdd);
    }
    
    public long getNumberOfSecondsRemainig() {
        return _NumberOfSecondsRemainig;
    }

    private void setNumberOfSecondsRemaining(long NumberOfSecondsRemainig) {
        
        this._NumberOfSecondsRemainig = NumberOfSecondsRemainig;
        
        _onNumberOfSecondsRemainingChanged.fire(new SimpleEventArgs(this));
        
    }

    public Period getRestPeriod() {
        return _RestPeriod;
    }

    private void setRestPeriod(Period RestPeriod) {
        
        this._RestPeriod = RestPeriod;
        this._RestPeriod.addOnDurationChangedListener(this::periodDurationChanged);
        
    }

    public Period getWorkPeriod() {
        return _WorkPeriod;
    }

    private void setWorkPeriod(Period WorkPeriod) {

        this._WorkPeriod = WorkPeriod;
        this._WorkPeriod.addOnDurationChangedListener(this::periodDurationChanged);
        
    }

    public Period getCurrentPeriod() {
        return _CurrentPeriod;
    }

    public void setCurrentPeriod(Period CurrentPeriod) {

        if (CurrentPeriod != null && (CurrentPeriod == _RestPeriod || CurrentPeriod == _WorkPeriod)) 
        {
            _CurrentPeriod = CurrentPeriod;
            
            _onCurrentPeriodChanged.fire(new SimpleEventArgs(this));
            
            setNumberOfSecondsRemaining(getCurrentPeriod().getDuration().toSeconds());
        }

    }
    
    // methods & constructors
    
    private EasyRestStatus(){
        
        _tickTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                tick();

            }
        }, 1000, 1000);
        
    }
    
    public EasyRestStatus(boolean isRunning) {
        
        this();
        
        setWorkPeriod(new Period("Work Period", "It is time for rest", Duration.ofMinutes(20), Period.EnAlarmType.ScreenOverlay, null));
        setRestPeriod(new Period("Rest Period", "It is time for work", Duration.ofMinutes(10), Period.EnAlarmType.ScreenOverlay, null));

        setCurrentPeriod(_WorkPeriod);

        if (isRunning)
            start();
    }

    private EasyRestStatus(Period workPeriod, Period restPeriod, boolean isRunning) {
        
        this();
        
        setWorkPeriod(workPeriod);
        setRestPeriod(restPeriod);
        
        setCurrentPeriod(_WorkPeriod);

        if (isRunning)
            start();
    }
    
    
    private void periodDurationChanged(SimpleEventArgs eventArgs){
        
        if (getCurrentPeriod() == ((Period) eventArgs.getSource()))
            setNumberOfSecondsRemaining(((Period) eventArgs.getSource()).getDuration().toSeconds());
        
    }
    
    private void switchPeriods() {
        
        if (getCurrentPeriod() == _RestPeriod) 
        {
            setCurrentPeriod(_WorkPeriod);
        } 
        else
        {
            setCurrentPeriod(_RestPeriod);
        }
        
    }

    public void pause() {

        pause(EnRunningStateChangeReason.NormalCall);
        
    }

    public void start() {

        start(EnRunningStateChangeReason.NormalCall);

    }
    
    private void start(EnRunningStateChangeReason reason){

        _isRunning = true;
        _onRunningStateChanged.fire(new RunningStateChangedEventArgs(this, reason));
        
    }
    
    private void pause(EnRunningStateChangeReason reason){
        
        _isRunning = false;
        _onRunningStateChanged.fire(new RunningStateChangedEventArgs(this, reason));
   
    }
    
    public boolean isRunning()
    {
        return _isRunning;
    }
    
    // this returns the String of the remining seconds in Minutes:Seconds format
    public String getReminingDurationString() 
    {
        long minutes = getNumberOfSecondsRemainig() / 60;
        long seconds = getNumberOfSecondsRemainig() % 60;
        
        return String.format("%02d:%02d", minutes, seconds);
    }

    public String convertToStringRecord() {
        return String.join(_RecordSeperator, _WorkPeriod.convertToStringRecord(), _RestPeriod.convertToStringRecord());
    }

    public static EasyRestStatus convertStringRecordToStatusObject(String Record, boolean isRunning) {
        
        if (Record == null) return null;

        try 
        {
            String[] arrRecord = Record.split(Pattern.quote(_RecordSeperator));
            
            Period WorkPeriod = Period.convertStringRecordToPeriod(arrRecord[0]);
            Period RestPeriod = Period.convertStringRecordToPeriod(arrRecord[1]);

            if (WorkPeriod == null || RestPeriod == null) {
                return null;
            }

            return new EasyRestStatus(WorkPeriod, RestPeriod, isRunning);
        } 
        catch (Exception any)
        {
            return null;
        }
    }

    private void tick(){
        
        if (!_isRunning) return;
        
        setNumberOfSecondsRemaining(_NumberOfSecondsRemainig - 1);
        
        if (getNumberOfSecondsRemainig() == 0)
        {
            pause(EnRunningStateChangeReason.TickCall);
            
            getCurrentPeriod().showEndAlarm();
            
            switchPeriods();
            
            start(EnRunningStateChangeReason.TickCall);
        }
    }
    
    public boolean saveToFile(String fileName){
        
        return FileHelper.writeRecordToFile(fileName, convertToStringRecord());
        
    }
    
    public static EasyRestStatus loadFromFile(String fileName, boolean isRunning){
        
        return convertStringRecordToStatusObject(FileHelper.readRecordFromFile(fileName), isRunning);
        
    }
    
    public static EasyRestStatus loadFromFileIfAnyOrDefault(String fileName, boolean isRunning){
        
        EasyRestStatus easyRestStatusToReturn = loadFromFile(fileName, isRunning);
        
        if (easyRestStatusToReturn != null)
            return easyRestStatusToReturn;
        else
            return new EasyRestStatus(isRunning);
        
    }
    
}

