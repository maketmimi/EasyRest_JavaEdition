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
        
        jMainTappedPane.setOpaque(true);
        jMainTappedPane.setBackground(Color.WHITE);
        jMainTappedPane.setForeground(Color.BLACK);
        jMainTappedPane.setFont(tapsFont);
        jMainTappedPane.addTab("Home", new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/home.png").getScaledInstance(32, 32, Image.SCALE_SMOOTH)), jPnlMainScreen, "Main screen");
        jMainTappedPane.addTab("Settings", new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/settings.png").getScaledInstance(32, 32, Image.SCALE_SMOOTH)), jScrlSettingsScreen, "App settings");
        jMainTappedPane.addTab("About", new ImageIcon(Toolkit.getDefaultToolkit().createImage("assets/images/menuimages/about.png").getScaledInstance(32, 32, Image.SCALE_SMOOTH)), null, "About screen");
        this.getContentPane().add(jMainTappedPane, BorderLayout.CENTER);
        
    }

    public JFrmMain(){
        
        InitializeComponents();

    }
    
    private final JTabbedPane jMainTappedPane = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
    private final JPnlMainScreen jPnlMainScreen = new JPnlMainScreen(this);
    private final JScrlSettingsScreen jScrlSettingsScreen = new JScrlSettingsScreen(this);
    
}
