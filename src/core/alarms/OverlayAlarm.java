package core.alarms;

import core.Configs;
import core.helpers.soundHelpers.SoundPlayer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class OverlayAlarm extends JFrame{

    public static void showAlarm(String message, short showTimeInSeconds){
        
        new OverlayAlarm(message, showTimeInSeconds).showAlarm();
        
    }
    
    private void InitializeComponents(){
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        // this jframe
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setIconImage(Toolkit.getDefaultToolkit().createImage(Configs.appIconPath));
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
    
    private OverlayAlarm(String message, short showTimeInSeconds)
    {
        InitializeComponents();
        _jlbMessage.setText(message);
        _alarmTimer = new Timer(showTimeInSeconds * 1000, this::alarmTimer_Tick);
        
        try{
            
            _soundPlayer = new SoundPlayer(Configs.defaultAlarmSoundPath);
            
        }
        catch (Exception any){
            
            _soundPlayer = null;
            
        }
        
    }

    private void btnCloseClicked(ActionEvent e){
        
        closeAlarm();
        
    }
    
    private void alarmTimer_Tick(ActionEvent e){
        
        closeAlarm();
        
    }
    
    private void showAlarm(){
        
        setVisible(true);
        
        if (_soundPlayer != null)
            _soundPlayer.PlayLooping();
        
        _alarmTimer.start();
        
    }

    private void closeAlarm(){
        
        _alarmTimer.stop();
        
        if (_soundPlayer != null)
            _soundPlayer.dispose();
        
        this.dispose();
        
    }
    
    private final JButton _jbtnClose = new JButton();
    private final JLabel _jlbMessage = new JLabel();
    private final Timer _alarmTimer;
    private SoundPlayer _soundPlayer;
    
}
