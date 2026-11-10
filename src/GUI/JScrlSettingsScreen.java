package GUI;

import javax.swing.JScrollPane;


public class JScrlSettingsScreen extends JScrollPane {

    public JScrlSettingsScreen(JFrmMain appMainWindow) {
    
        jPnlSettingsScreen = new JPnlSettingsScreen(appMainWindow);
        this.setViewportView(jPnlSettingsScreen);
        
    }
    
    private final JPnlSettingsScreen jPnlSettingsScreen;
    
}
