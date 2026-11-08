package core.alarms;

import core.helpers.soundHelpers.SoundPlayer;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class SoundOnlyAlarm {

    public static void PlayAlarm(short TimeOutInSeconds, String AlarmSoundPath) throws Exception
    {
        new SoundOnlyAlarm(TimeOutInSeconds, AlarmSoundPath)._PlayAlarm();
    }

    private final SoundPlayer _AlarmSoundPlayer;
    private final Timer _PlayTimer;

    private SoundOnlyAlarm(short TimeOutInSeconds, String AlarmSoundPath) throws Exception
    {

        _PlayTimer = new Timer(TimeOutInSeconds * 1000, this::_PlayTimer_Tick);
        _AlarmSoundPlayer = new SoundPlayer(AlarmSoundPath);
        
    }

    private void _PlayAlarm() {

        _AlarmSoundPlayer.PlayLooping();
        _PlayTimer.start();
        
    }

    private void _PlayTimer_Tick(ActionEvent e) {
        
        _PlayTimer.stop();
        _AlarmSoundPlayer.dispose();
    
    }

}
