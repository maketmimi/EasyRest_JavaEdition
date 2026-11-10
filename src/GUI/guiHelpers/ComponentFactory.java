package GUI.guiHelpers;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


public final class ComponentFactory {

    public static JLabel CreateSimpleJLable(String text, Color foreGround, int horizontalAlignment, Font font){
        
        JLabel createdJLable = new JLabel();
        
        createdJLable.setText(text);
        createdJLable.setForeground(foreGround);
        createdJLable.setHorizontalAlignment(horizontalAlignment);
        createdJLable.setFont(font);

        return createdJLable;
    }
    
    
}
