package GUI;

import GUI.guiHelpers.GUIConfigs;
import core.Configs;
import core.EasyRestStatus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemTray;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JFrmMain extends JFrame {
    
    private void initialize_jMainTappedPane(){
        
        // _jMainTappedPane
        
        _jMainTappedPane.setOpaque(true);
        _jMainTappedPane.setBackground(Color.WHITE);
        _jMainTappedPane.setForeground(Color.BLACK);
        _jMainTappedPane.setFont(GUIConfigs.tapsFont);
        _jMainTappedPane.addTab("Home", new ImageIcon(GUIConfigs.getHomeImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)), _jPnlMainScreen, "Main screen");
        _jMainTappedPane.addTab("Settings", new ImageIcon(GUIConfigs.getSettingsImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)), _jScrlSettingsScreen, "App settings");
        _jMainTappedPane.addTab("About", new ImageIcon(GUIConfigs.getAboutImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)), _jPnlAboutScreen, "About screen");
        _jMainTappedPane.addChangeListener(this::selectedTapChanged);
    
    }
    
    private void initialize_appTrayIcon(){

        try
        {
            _systemTray = SystemTray.getSystemTray();
            
            _systemTray.add(_appTrayIcon);
            
        }
        catch (Exception any)
        {
            _jPnlMainScreen.getjBtnHideApp().setEnabled(false);
        }
        
    }
    
    private void initializeComponents(){
        
        // this jframe
        this.setTitle("EasyRest - Java Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Configs.getAppIconImage());
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(null);

        // _jMainTappedPane
        initialize_jMainTappedPane();
        this.getContentPane().add(_jMainTappedPane, BorderLayout.CENTER);
        
        // _appTrayIcon
        initialize_appTrayIcon();
        
    }

    public JFrmMain(){
        
        initializeComponents();

    }
    
    private void selectedTapChanged(ChangeEvent e){
        
        if (_jMainTappedPane.getSelectedComponent() == _jScrlSettingsScreen)
        {
            _jScrlSettingsScreen.updateSettingsScreenUI();
        }
        
    }
    
    public void showSettings(){

        if (!this.isShowing()) this.setVisible(true);
        _jMainTappedPane.setSelectedComponent(_jScrlSettingsScreen);
        
    }
    
    private final EasyRestStatus _easyRestStatus = EasyRestStatus.loadFromFileIfAnyOrDefault(Configs.easyRestStatusFilePath, true);
    
    private final JTabbedPane _jMainTappedPane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
    private final JPnlMainScreen _jPnlMainScreen = new JPnlMainScreen(this);
    private final JScrlSettingsScreen _jScrlSettingsScreen = new JScrlSettingsScreen(this);
    private final JPnlAboutScreen _jPnlAboutScreen = new JPnlAboutScreen();
    private final AppTrayIcon _appTrayIcon = new AppTrayIcon(this);
    private SystemTray _systemTray = null;

    public EasyRestStatus getEasyRestStatus() {
        return _easyRestStatus;
    }
    
}
