package core;

import core.helpers.StringHelpers;
import java.time.Duration;
import core.helpers.soundHelpers.SoundHelpers;

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
    private String _EndOfPeriodMessage;
    private EnAlarmType _AlarmType;

    // path to alarm sound, null or white space means Default sound
    private String _AlarmSoundPath;

    public String getAlarmSoundPath() {
        
        if (StringHelpers.isNullOrBlank(_AlarmSoundPath))
            return "";
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

    public Period(String title, String endOfPeriodMessage, Duration duration, EnAlarmType alarmType, String AlarmSoundPath) {
        
        setTitle(title);
        setDuration(duration);
        setEndOfPeriodMessage(endOfPeriodMessage);
        setAlarmType(alarmType);
        setAlarmSoundPath(AlarmSoundPath);

    }

    private void ShowScreenOverlayAlarm() {
//        FrmAlarmOverlay frmAlarm;
//
//        switch (ValidateAlarmSoundFile()) {
//            case EnValidateSoundFileResult.Valid:
//                frmAlarm = new FrmAlarmOverlay(_EndOfPeriodMessage, AlarmSoundPath, 20);
//                break;
//            default:
//                frmAlarm = new FrmAlarmOverlay(_EndOfPeriodMessage, Resources.DefaultAlarmSound, 20);
//                break;
//        }
//
//        frmAlarm.ShowDialog();
    }

    private void ShowNotificationAlarm() {
//        NotificationAlarm.ShowAlarm(_EndOfPeriodMessage);
    }

    private void PlaySoundOnlyAlarm() {
//        if (ValidateAlarmSoundFile() == EnValidateSoundFileResult.Valid) {
//            SoundOnlyAlarm.PlayAlarm(10, AlarmSoundPath);
//        } else {
//            SoundOnlyAlarm.PlayAlarm(10, Resources.DefaultAlarmSound);
//        }
    }

    public void ShowEndAlarm() {
        switch (_AlarmType) {
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

    public SoundHelpers.EnValidateSoundFileResult ValidateAlarmSoundFile(){
        
        return SoundHelpers.ValidateAlarmSoundFile(_AlarmSoundPath);
    
    }

    public boolean IsDefaultSound() {
        
        return ValidateAlarmSoundFile() == SoundHelpers.EnValidateSoundFileResult.Default;
    
    }

}
