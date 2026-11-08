package core.alarms;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Notification {

    public static void showNotificationMessage(String title, String message, TrayIcon.MessageType messageType, Image trayIconImage, short showTimeInSeconds) throws UnsupportedOperationException, AWTException
    {
        new Notification(showTimeInSeconds, trayIconImage).Show(title, message, messageType);
    }
    
    private final SystemTray _systemTray;
    private final TrayIcon _trayIcon;
    private final Timer _notificationTimer;
    
    public Notification(short showTimeInSeconds, Image trayIconImage) throws UnsupportedOperationException, AWTException
    {
        _systemTray = SystemTray.getSystemTray();
        
        _trayIcon = new TrayIcon(trayIconImage);
        _trayIcon.setImageAutoSize(true);
        
        _systemTray.add(_trayIcon);
        
        _notificationTimer = new Timer(showTimeInSeconds * 1000, this::notificationTimedOut);
    }

    private void Show(String title, String message, TrayIcon.MessageType messageType){
        
        _trayIcon.displayMessage(title, message, messageType);
        _notificationTimer.start();
        
    }
    
    private void notificationTimedOut(ActionEvent e){

        _notificationTimer.stop();
        _systemTray.remove(_trayIcon);

    }
    
}
