package GUI;

import GUI.guiHelpers.ComponentFactory;
import GUI.guiHelpers.GridBagConstraintsBuilder;
import GUI.guiHelpers.JMultiLineLable;
import core.Configs;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class JPnlAboutScreen extends JPanel {

    private void initializeHeader(){
        
        JLabel jLblAppTitle = ComponentFactory.CreateSimpleJLable("<html><center>Easy Rest<br>Java Edition</center></html>", Color.BLACK, JLabel.CENTER, new Font("Comic Sans MS", Font.BOLD, 40));
        
        JLabel jLblAppIconDisplay = new JLabel();
        jLblAppIconDisplay.setPreferredSize(new Dimension(150, 150));
        jLblAppIconDisplay.setHorizontalAlignment(JLabel.CENTER);
        jLblAppIconDisplay.setIcon(new ImageIcon(Configs.getAppIconImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH)));

        _jPnlHeader.setLayout(new GridLayout(1, 2));
        _jPnlHeader.setOpaque(false);
        _jPnlHeader.add(jLblAppTitle);
        _jPnlHeader.add(jLblAppIconDisplay);
        
    }
    
    private void initializeBody(){
        
        JMultiLineLable jLblBody = new JMultiLineLable();
        
        jLblBody.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        jLblBody.setForeground(Color.BLACK);

        String bodyText = "Easy Rest is an easy to use app that reminds you to take regular breaks with an adjustable periods."
                + System.lineSeparator()
                + System.lineSeparator()
                + "Version 1.0.0"
                + System.lineSeparator()
                + "Developed by Malek Altamimi.";
        
        jLblBody.setText(bodyText);
        
        _jPnlBody.setLayout(new BorderLayout());
        _jPnlBody.setOpaque(false);
        _jPnlBody.add(jLblBody);
        
    }
    
    private void initializeFooter(){
        
        JLabel jLblMalekALtamimiLogoDisplay = new JLabel();
        jLblMalekALtamimiLogoDisplay.setPreferredSize(new Dimension(50, 50));
        jLblMalekALtamimiLogoDisplay.setHorizontalAlignment(JLabel.CENTER);
        jLblMalekALtamimiLogoDisplay.setIcon(new ImageIcon(Configs.getMalekAltamimiLogoImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        
        JLabel jLblMalekAltamimiPortfolioLink = ComponentFactory.CreateSimpleJLable("Altamimi.ly", Color.BLACK, JLabel.CENTER, new Font("Comic Sans MS", Font.PLAIN, 20));
        jLblMalekAltamimiPortfolioLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLblMalekAltamimiPortfolioLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                malekAltamimiPorfolioLinkClicked(e);

            }
        });
        
        _jPnlFooter.setLayout(new GridBagLayout());
        _jPnlFooter.setOpaque(false);
        _jPnlFooter.add(jLblMalekALtamimiLogoDisplay, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0)));
        _jPnlFooter.add(jLblMalekAltamimiPortfolioLink, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 0, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(5, 0, 3, 0)));
        
    }
    
    
    private void initializeComponents(){
        
        // this jpanel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        
        // _jPnlHeader
        initializeHeader();
        this.add(_jPnlHeader, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));

        // _jPnlBody
        initializeBody();
        this.add(_jPnlBody, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 10, 5, 10)));

        // _jPnlFooter
        initializeFooter();
        this.add(_jPnlFooter, GridBagConstraintsBuilder.CreateConstraint(0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(3, 10, 3, 10)));
        
    }
    
    public JPnlAboutScreen() {
    
        initializeComponents();
    
    }

    
    private void malekAltamimiPorfolioLinkClicked(MouseEvent e){
        
        if (SwingUtilities.isLeftMouseButton(e))
        {
            try{

                Desktop.getDesktop().browse(new URI(Configs.malekAltamimiPortfolioLink));

            }
            catch (Exception any)
            {
                // do nothing
            }
        }
            
    }
    
    private final JPanel _jPnlHeader = new JPanel();
    private final JPanel _jPnlBody = new JPanel();
    private final JPanel _jPnlFooter = new JPanel();
    
}
