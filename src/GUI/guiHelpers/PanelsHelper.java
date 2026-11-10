package GUI.guiHelpers;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public final class PanelsHelper {

    public static JPanel CreateTitledJPanel(String title){
        
        JPanel createdPanel = new JPanel();
        
        createdPanel.setLayout(new GridBagLayout());
        createdPanel.setOpaque(false);
        LineBorder createdPanelLineBorder = new LineBorder(Color.BLACK, 1);
        TitledBorder createdPanelBorder = new TitledBorder(createdPanelLineBorder, title, TitledBorder.LEFT, TitledBorder.TOP, new Font("Comic Sans MS", Font.BOLD, 30), GUIConfigs.lablesBlue);
        createdPanel.setBorder(createdPanelBorder);
        
        return createdPanel;
    }
    
}
