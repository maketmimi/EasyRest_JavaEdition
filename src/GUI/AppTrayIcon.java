package GUI;

import GUI.guiHelpers.GUIConfigs;
import core.Configs;
import core.events.RunningStateChangedEventArgs;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;


public class AppTrayIcon extends TrayIcon {

    private void initialize_appTrayIconMenu(){
        
        // _ChkappStateSwitch
        _ChkappStateSwitch.setFont(GUIConfigs.popUpMenuFont);
        _ChkappStateSwitch.addItemListener(this::_ChkappStateSwitchStateToggled);
        _appMainWindow.getEasyRestStatus().addOnRunningStateChangedListener(this::appRunningStateChanged);
        
        // _ChkappVisibiltySwitch
        _ChkappVisibiltySwitch.setFont(GUIConfigs.popUpMenuFont);
        _ChkappVisibiltySwitch.addItemListener(this::_ChkappVisibiltySwitchToggled);
        
        // _MishowSettings
        _MishowSettings.setFont(GUIConfigs.popUpMenuFont);
        _MishowSettings.addActionListener(this::_MishowSettingsClicked);
        
        // _MiExitApp
        _MiExitApp.setFont(GUIConfigs.popUpMenuFont);
        _MiExitApp.addActionListener(this::_MiExitAppClicked);
        
        // _appTrayIconMenu
        _appTrayIconMenu.add(_ChkappStateSwitch);
        _appTrayIconMenu.addSeparator();
        _appTrayIconMenu.add(_ChkappVisibiltySwitch);
        _appTrayIconMenu.add(_MishowSettings);
        _appTrayIconMenu.addSeparator();
        _appTrayIconMenu.add(_MiExitApp);
        
    }
    
    private void initialize(){
        
        // this tray icon
        this.setImageAutoSize(true);
        this.addActionListener(this::appIconTrayClicked);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (SwingUtilities.isLeftMouseButton(e))
                    appIconTrayClicked(null);

            }
        });
        this.setToolTip("EasyRest - Java Edition");
        
        // _appTrayIconMenu
        initialize_appTrayIconMenu();
        this.setPopupMenu(_appTrayIconMenu);
        
        // _appMainWindow
        _appMainWindow.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
            
                appMainWindowVisibilityChanged(false);
            
            }

            @Override
            public void componentShown(ComponentEvent e) {

                appMainWindowVisibilityChanged(true);
                
            }
        
        });
        
    }
    
    public AppTrayIcon(JFrmMain appMainWindow){
        
        super(Configs.getAppIconImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        _appMainWindow = appMainWindow;
        initialize();
        
    }

    private void _MiExitAppClicked(ActionEvent e){
        
        System.exit(0);
        
    }
    
    private void _MishowSettingsClicked(ActionEvent e){

        _appMainWindow.showSettings();
        
    }
    
    private void _ChkappStateSwitchStateToggled(ItemEvent e){
        
        if (_ChkappStateSwitch.getState())
            _appMainWindow.getEasyRestStatus().start();
        else
            _appMainWindow.getEasyRestStatus().pause();
        
    }
    
    private void update_ChkappStateSwitch(){
        
        if (_ChkappStateSwitch.getState())
        {
            _ChkappStateSwitch.setLabel("Running");
        }
        else
        {
            _ChkappStateSwitch.setLabel("Stopped");
        }
        
    }
    
    private void _ChkappVisibiltySwitchToggled(ItemEvent e){

        _appMainWindow.setVisible(_ChkappVisibiltySwitch.getState());
        
    }
    
    private void update_ChkappVisibiltySwitch(){
        
        if (_ChkappVisibiltySwitch.getState())
        {
            _ChkappVisibiltySwitch.setLabel("Shown");
        }
        else
        {
            _ChkappVisibiltySwitch.setLabel("Hidden");
        }
        
    }
    
    private void appMainWindowVisibilityChanged(boolean isShown){
        
        _ChkappVisibiltySwitch.setState(_appMainWindow.isShowing());
        update_ChkappVisibiltySwitch();
        
    }
    
    private void appRunningStateChanged(RunningStateChangedEventArgs eventArgs){
        
        _ChkappStateSwitch.setState(_appMainWindow.getEasyRestStatus().isRunning());
        update_ChkappStateSwitch();
        
    }
    
    private void appIconTrayClicked(ActionEvent e){
        
        _appMainWindow.setVisible(true);
        
    }
    
    private final JFrmMain _appMainWindow;
    
    private final PopupMenu _appTrayIconMenu = new PopupMenu();
    private final CheckboxMenuItem _ChkappStateSwitch = new CheckboxMenuItem("Running", true);
    private final CheckboxMenuItem _ChkappVisibiltySwitch = new CheckboxMenuItem("Hidden", false);
    private final MenuItem _MishowSettings = new MenuItem("Settings");
    private final MenuItem _MiExitApp = new MenuItem("Exit");
    
}

