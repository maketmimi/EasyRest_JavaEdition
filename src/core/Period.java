package core;

import core.alarms.Notification;
import core.alarms.OverlayAlarm;
import core.alarms.SoundOnlyAlarm;
import core.events.GeneralEvent;
import core.helpers.StringHelpers;
import java.time.Duration;
import java.awt.TrayIcon;
import core.events.IGeneralListener;
import core.events.SimpleEventArgs;
import java.util.regex.Pattern;

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
    
    private GeneralEvent _onDurationChanged = new GeneralEvent();
    
    private String _EndOfPeriodMessage;
    private EnAlarmType _AlarmType;

    // path to alarm sound, null or white space means Default sound
    private String _AlarmSoundPath;

    public void addOnDurationChangedListener(IGeneralListener listenerToAdd) {
        _onDurationChanged.addListener(listenerToAdd);
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

    public void setDuration(Duration duration) {
        
        this._duration = duration.toSeconds() < 1 ? Duration.ofSeconds(1) : duration;
        _onDurationChanged.fire(new SimpleEventArgs(this));
        
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
        this._duration = duration.toSeconds() < 1 ? Duration.ofSeconds(1) : duration;
        this._AlarmType = alarmType;
        this._AlarmSoundPath = AlarmSoundPath;

    }

    private void showScreenOverlayAlarm() {
        
        OverlayAlarm.showAlarm(getEndOfPeriodMessage(), (short) 10, getAlarmSoundPath());

    }

    private void showNotificationAlarm() throws Exception
    {
        Notification.showNotificationMessage("Alarm", getEndOfPeriodMessage(), TrayIcon.MessageType.INFO, Configs.getAppIconImage(), (short) 20);
    }

    private void playSoundOnlyAlarm() throws Exception
    {
        SoundOnlyAlarm.PlayAlarm((short) 10, getAlarmSoundPath());
    }

    public void showEndAlarm() {
        
        try{
            
            switch (getAlarmType()) {
                case EnAlarmType.NotificationsOnly:
                    showNotificationAlarm();
                    break;
                case EnAlarmType.SoundOnly:
                    playSoundOnlyAlarm();
                    break;
                default:
                    showScreenOverlayAlarm();
                    break;
            }
        }
        catch (Exception any){
            
            showScreenOverlayAlarm();
            
        }
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public String convertToStringRecord() {
        return String.join(_RecordSeperator, getTitle(), getEndOfPeriodMessage(), Long.toString(getDuration().toSeconds()), getAlarmType().toString(), getAlarmSoundPath());
    }

    public static Period convertStringRecordToPeriod(String Record) {
        
        String[] arrRecord = Record.split(Pattern.quote(_RecordSeperator));

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
