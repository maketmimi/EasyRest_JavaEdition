package GUI.guiHelpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicButtonUI;


public final class ComponentFactory {

    public static JLabel CreateSimpleJLable(String text, Color foreGround, int horizontalAlignment, Font font){
        
        JLabel createdJLable = new JLabel();
        
        createdJLable.setText(text);
        createdJLable.setForeground(foreGround);
        createdJLable.setHorizontalAlignment(horizontalAlignment);
        createdJLable.setFont(font);

        return createdJLable;
    }
    
    public static JButton createSimpleFlatJButton(String text, Dimension preferredSize, Font font){
        
        JButton createdJButton = new JButton();
        
        createdJButton.setUI(new BasicButtonUI());
        createdJButton.setText(text);
        createdJButton.setPreferredSize(preferredSize);
        createdJButton.setFont(font);
        
        return createdJButton;
    }
    
    
}
