package core;

import core.alarms.Notification;
import core.alarms.OverlayAlarm;
import core.alarms.SoundOnlyAlarm;
import core.events.IActionListener;
import core.helpers.StringHelpers;
import java.time.Duration;
import java.awt.TrayIcon;

public class Period {

    public enum EnAlarmType {
        NotificationsOnly,
        SoundOnly,
        ScreenOverlay
    }
    
    private static final String _RecordSeperator  = "[PSep]";

    // class properties
    
    private String _Title;
    private Duration _duration;
    
    private IActionListener _onDurationChanged = null;
    
    private String _EndOfPeriodMessage;
    private EnAlarmType _AlarmType;

    // path to alarm sound, null or white space means Default sound
    private String _AlarmSoundPath;

    public void setOnDurationChangedListener(IActionListener _onDurationChanged) {
        this._onDurationChanged = _onDurationChanged;
    }
    
    public String getAlarmSoundPath() {
        
        if (StringHelpers.isNullOrBlank(_AlarmSoundPath))
            return Configs.defaultAlarmSoundPath;
        else
            return _AlarmSoundPath;
        
    }

    public void setAlarmSoundPath(String _AlarmSoundPath) {
        this._AlarmSoundPath = _AlarmSoundPath;
    }

    public String getTitle() {
        return _Title;
    }

    public void setTitle(String Title) {
        this._Title = Title;
    }

    public Duration getDuration() {
        return _duration;
    }

    public void setDuration(Duration Duration) {
        this._duration = Duration;
        
        if (_onDurationChanged != null)
            _onDurationChanged.actionPerformed(this);
    }

    public String getEndOfPeriodMessage() {
        return _EndOfPeriodMessage;
    }

    public void setEndOfPeriodMessage(String EndOfPeriodMessage) {
        this._EndOfPeriodMessage = EndOfPeriodMessage;
    }

    public EnAlarmType getAlarmType() {
        return _AlarmType;
    }

    public void setAlarmType(EnAlarmType AlarmType) {
        this._AlarmType = AlarmType;
    }

    // class methods and constructors

    // null alarm sound path for default sound
    public Period(String title, String endOfPeriodMessage, Duration duration, EnAlarmType alarmType, String AlarmSoundPath) {
        
        this._Title = title;
        this._EndOfPeriodMessage = endOfPeriodMessage;
        this._duration = duration;
        this._AlarmType = alarmType;
        this._AlarmSoundPath = AlarmSoundPath;

    }

    private void ShowScreenOverlayAlarm() {
        
        OverlayAlarm.showAlarm(getEndOfPeriodMessage(), (short) 10, getAlarmSoundPath());

    }

    private void ShowNotificationAlarm() throws Exception
    {
        Notification.showNotificationMessage("Alarm", getEndOfPeriodMessage(), TrayIcon.MessageType.INFO, Configs.getAppIconImage(), (short) 10);
    }

    private void PlaySoundOnlyAlarm() throws Exception
    {
        SoundOnlyAlarm.PlayAlarm((short) 10, getAlarmSoundPath());
    }

    public void ShowEndAlarm() {
        
        try{
            
            switch (getAlarmType()) {
                case EnAlarmType.NotificationsOnly:
                    ShowNotificationAlarm();
                    break;
                case EnAlarmType.SoundOnly:
                    PlaySoundOnlyAlarm();
                    break;
                default:
                    ShowScreenOverlayAlarm();
                    break;
            }
        }
        catch (Exception any){
            
            ShowScreenOverlayAlarm();
            
        }
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public String ConvertToStringRecord() {
        return String.join(_RecordSeperator, getTitle(), getEndOfPeriodMessage(), Long.toString(getDuration().toSeconds()), getAlarmType().toString(), getAlarmSoundPath());
    }

    public static Period ConvertStringRecordToPeriod(String Record) {
        
        String[] arrRecord = Record.split(_RecordSeperator);

        try 
        {
            
            return new Period
            (
                arrRecord[0], 
                arrRecord[1],
                Duration.ofSeconds(Long.parseLong(arrRecord[2])),
                EnAlarmType.valueOf(arrRecord[3]),
                arrRecord[4]
            );
            
        }
        catch (Exception any)  
        {
            return null;
        }
    
    }

}
