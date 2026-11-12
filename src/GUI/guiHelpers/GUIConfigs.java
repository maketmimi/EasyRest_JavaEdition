package GUI.guiHelpers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;


public final class GUIConfigs {

    public static Color lablesBlue = new Color(5, 0, 23);

    public static Font defaultLablesFont = new Font("Comic Sans MS", Font.PLAIN, 30);
    
    public static Font defaultTextFieldsFont = new Font("Comic Sans MS", Font.PLAIN, 20);
    
    public static Font numaricUpDownFont = new Font("Comic Sans MS", Font.BOLD, 30);

    public static Font popUpMenuFont = new Font("Comic Sans MS", Font.BOLD, 15);
    
    public static Font tapsFont = new Font("Comic Sans MS", Font.BOLD, 20);
    
    
    public static Image getExitImage(){
        
        return Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/exit.png");
        
    }
    
    public static Image getAboutImage(){
        
        
        return Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/about.png");
        
    }
    
    public static Image getHomeImage(){
        
        return Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/home.png");
        
    }

    public static Image getSettingsImage(){
        
        return Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/settings.png");
        
    }
    
}
