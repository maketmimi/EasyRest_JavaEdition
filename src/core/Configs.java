package core;

import java.awt.Image;
import java.awt.Toolkit;


public final class Configs {

    public final static String appIconPath = "assets/images/appicon.png";
    public final static String malekAltamimiLogoPath = "assets/images/malekaltamimilogo.png";
    public final static String defaultAlarmSoundPath = "assets/sounds/DefaultAlarmSound.wav";
    public final static String malekAltamimiPortfolioLink = "https://altamimi.ly";
    public final static String easyRestGithubPageLink = "https://github.com/maketmimi/EasyRest_JavaEdition";
    public final static String easyRestStatusFilePath = "data/easyreststatusconfigs";
    
    public static Image getAppIconImage(){
        
        return Toolkit.getDefaultToolkit().createImage(appIconPath);
        
    }
    
    public static Image getMalekAltamimiLogoImage(){
        
        return Toolkit.getDefaultToolkit().createImage(malekAltamimiLogoPath);
        
    }
    
}
