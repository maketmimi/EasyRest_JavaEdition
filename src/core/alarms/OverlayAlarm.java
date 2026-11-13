package core.alarms;

import core.Configs;
import core.helpers.soundHelpers.SoundPlayer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class OverlayAlarm extends JFrame{

    public static void showAlarm(String message, short showTimeInSeconds, String alarmSoundPath){
        
        new OverlayAlarm(message, showTimeInSeconds, alarmSoundPath).showAlarm();
        
    }
    
    private void InitializeComponents(){
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // this jframe
        this.setTitle("EasyRest - Overlay Alarm");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setIconImage(Configs.getAppIconImage());
        this.setUndecorated(true);
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setOpacity(0.95f);
        this.setType(Type.UTILITY);
        this.getContentPane().setLayout(new GridBagLayout());
        
        // jlbMessage
        _jlbMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        _jlbMessage.setForeground(Color.BLACK);
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 100, 0);
        this.getContentPane().add(_jlbMessage, gridBagConstraints);
        
        // jbtnClose
        _jbtnClose.setText("Close");
        _jbtnClose.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        _jbtnClose.setPreferredSize(new Dimension(200, 80));
        _jbtnClose.addActionListener(this::btnCloseClicked);
        _jbtnClose.setBackground(new Color(99, 9, 9));
        _jbtnClose.setForeground(Color.WHITE);
        gridBagConstraints.fill = GridBagConstraints.NONE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        this.getContentPane().add(_jbtnClose, gridBagConstraints);
        
    }
    
    private OverlayAlarm(String message){
        
        InitializeComponents();
        _jlbMessage.setText(message);
        
    }
    
    // Parent constructor
    private OverlayAlarm(String message, short showTimeInSeconds, String alarmSoundPath)
    {
        this(message);
        
        setScreenToShowOverlayOn(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
        
        _alarmTimer = new Timer(showTimeInSeconds * 1000, this::alarmTimer_Tick);
        
        try{
            
            _soundPlayer = new SoundPlayer(alarmSoundPath);
            
        }
        catch (Exception any){
            
            _soundPlayer = null;
            
        }
        
    }

    // child constructor
    private OverlayAlarm(OverlayAlarm jFrmParent, GraphicsDevice screenToShowOverlayOn, String message){
        
        this(message);
        setjFrmParent(jFrmParent);
        setScreenToShowOverlayOn(screenToShowOverlayOn);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        getjFrmParent().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                parentFrameClosed();

            }
            
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                childFrameClosing();

            }
        });
        
    }
    
    private void btnCloseClicked(ActionEvent e){
        
        getjFrmParent().closeAlarm();
        
    }
    
    private void alarmTimer_Tick(ActionEvent e){
        
        closeAlarm();
        
    }
    
    private void showChildOverlaysIfAny(){
        
        if (isChildOverlayFrame()) return;
        
        GraphicsDevice[] allScreens = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        GraphicsDevice primaryScreen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        
        if (allScreens == null) return;
        
        for (GraphicsDevice screen : allScreens)
        {
            if (screen == primaryScreen) continue;
            
            new OverlayAlarm(this, screen, getAlarmMessage()).showAlarm();
        }

    }
    
    private void showAlarm(){
        
        setVisible(true);
        
        if (!isChildOverlayFrame())
            showChildOverlaysIfAny();
        
        if (_soundPlayer != null)
            _soundPlayer.PlayLooping();
        
        if (_alarmTimer != null)
            _alarmTimer.start();
        
    }

    private void closeAlarm(){
        
        if (_alarmTimer != null)
            _alarmTimer.stop();
        
        if (_soundPlayer != null)
            _soundPlayer.dispose();
        
        this.dispose();
    }
    
    private void parentFrameClosed(){

        if (!isChildOverlayFrame()) return; // just an additional check although this should not be called from a parent overlay frame

        closeAlarm();
        
    }
    
    private void childFrameClosing(){
        
        if (!isChildOverlayFrame()) return; // just an additional check although this should not be called from a parent overlay frame
        
        getjFrmParent().closeAlarm();
        
    }
    
    private final JButton _jbtnClose = new JButton();
    private final JLabel _jlbMessage = new JLabel();
    private Timer _alarmTimer = null;
    private SoundPlayer _soundPlayer = null;
    
    private GraphicsDevice _screenToShowOverlayOn = null;
    private OverlayAlarm _jFrmParent = null;
    
    private GraphicsDevice getScreenToShowOverlayOn() {
        return _screenToShowOverlayOn;
    }

    private void setScreenToShowOverlayOn(GraphicsDevice screenToShowOverlayOn) {
        
        if (screenToShowOverlayOn == null) return;
        
        this._screenToShowOverlayOn = screenToShowOverlayOn;
        
        this.setLocation(this._screenToShowOverlayOn.getDefaultConfiguration().getBounds().getLocation());

    }

    private OverlayAlarm getjFrmParent() {
        return _jFrmParent == null ? this : _jFrmParent;
    }

    private void setjFrmParent(OverlayAlarm jFrmParent) {
        this._jFrmParent = jFrmParent;
    }
    
    private boolean isChildOverlayFrame(){
        
        return _jFrmParent != null;
        
    }
    
    private String getAlarmMessage(){
        
        return _jlbMessage.getText();
        
    }
    
}
