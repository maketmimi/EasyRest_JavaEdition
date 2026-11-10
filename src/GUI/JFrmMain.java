package GUI;

import core.Configs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


public class JFrmMain extends JFrame {
    
    
    private void InitializeComponents(){
        
        // this jframe
        this.setTitle("EasyRest - Java Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Configs.getAppIconImage());
        this.setMinimumSize(new Dimension(600, 500));

        // jMainTappedPane
        Font tapsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        
        _jMainTappedPane.setOpaque(true);
        _jMainTappedPane.setBackground(Color.WHITE);
        _jMainTappedPane.setForeground(Color.BLACK);
        _jMainTappedPane.setFont(tapsFont);
        _jMainTappedPane.addTab("Home", new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/home.png").getScaledInstance(32, 32, Image.SCALE_SMOOTH)), _jPnlMainScreen, "Main screen");
        _jMainTappedPane.addTab("Settings", new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/settings.png").getScaledInstance(32, 32, Image.SCALE_SMOOTH)), _jScrlSettingsScreen, "App settings");
        _jMainTappedPane.addTab("About", new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/about.png").getScaledInstance(32, 32, Image.SCALE_SMOOTH)), _jPnlAboutScreen, "About screen");
        this.getContentPane().add(_jMainTappedPane, BorderLayout.CENTER);
        
    }

    public JFrmMain(){
        
        InitializeComponents();

    }
    
    private final JTabbedPane _jMainTappedPane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
    private final JPnlMainScreen _jPnlMainScreen = new JPnlMainScreen(this);
    private final JScrlSettingsScreen _jScrlSettingsScreen = new JScrlSettingsScreen(this);
    private final JPnlAboutScreen _jPnlAboutScreen = new JPnlAboutScreen();
    
}
