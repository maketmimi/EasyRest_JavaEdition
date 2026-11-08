package core.helpers.soundHelpers;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SoundPlayer {

    private String _pathToSoundFile = null;
    private final Clip clip = AudioSystem.getClip();
    
    public String getPathToSoundFile() {
        return _pathToSoundFile;
    }

    public SoundPlayer(String pathToSoundFile) throws Exception {
    
        _pathToSoundFile = pathToSoundFile;
        
        clip.open(AudioSystem.getAudioInputStream(new File(getPathToSoundFile())));
    
    }

    public void Play(){
        
        clip.start();
        
    }
    
    public void PlayLooping()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void Stop(){
        
        clip.stop();

    }

    public void Close(){
        
        clip.close();
        
    }
    
    public void dispose(){
        
        Stop();
        Close();
        
    }
    
}
