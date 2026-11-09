package core;

import java.awt.Image;
import java.awt.Toolkit;


public final class Configs {

    public final static String appIconPath = "assets/images/appicon.png";
    public final static String defaultAlarmSoundPath = "assets/sounds/DefaultAlarmSound.wav";
    
    public static Image getAppIconImage(){
        
        return Toolkit.getDefaultToolkit().createImage(appIconPath);
        
    }
    
    
}
