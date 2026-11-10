package GUI;

import javax.swing.JScrollPane;


public class JScrlSettingsScreen extends JScrollPane {

    public JScrlSettingsScreen(JFrmMain appMainWindow) {
    
        jPnlSettingsScreen = new JPnlSettingsScreen(appMainWindow);
        this.setViewportView(jPnlSettingsScreen);
        this.getVerticalScrollBar().setUnitIncrement(10);
        
    }
    
    private final JPnlSettingsScreen jPnlSettingsScreen;
    
}
