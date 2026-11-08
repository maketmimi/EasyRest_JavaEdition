package core.helpers.soundHelpers;

import core.helpers.StringHelpers;
import java.io.File;

public final class SoundHelpers {

    public enum EnValidateSoundFileResult {
        Default,
        Valid,
        FileNotFound,
        InvalidFormat
    }
    
    public static EnValidateSoundFileResult ValidateAlarmSoundFile(String AlarmSoundPath) {

        // we should check for the file format in the future
        
        if (StringHelpers.isNullOrBlank(AlarmSoundPath)) 
        {
            return EnValidateSoundFileResult.Default;
        } 
        else if (!(new File(AlarmSoundPath).exists()))
        {
            return EnValidateSoundFileResult.FileNotFound;
        } 
        else
        {
            return EnValidateSoundFileResult.Valid;
        }
        
    }
 
}
