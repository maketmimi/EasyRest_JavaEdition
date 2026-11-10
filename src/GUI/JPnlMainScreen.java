package GUI;

import GUI.guiHelpers.ComponentFactory;
import GUI.guiHelpers.GridBagConstraintsBuilder;
import GUI.guiHelpers.PanelsHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicButtonUI;


public class JPnlMainScreen extends JPanel {

    private void InitializeComponents(){
        
        
        // this jpanel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        
        // jTgbAppStateSwitch
        _jTgbAppStateSwitch.setPreferredSize(new Dimension(300, 80));
        _jTgbAppStateSwitch.setBackground(Color.GREEN);
        _jTgbAppStateSwitch.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        _jTgbAppStateSwitch.setForeground(Color.WHITE);
        _jTgbAppStateSwitch.addActionListener(this::appStateSwitchToggled);
        _jTgbAppStateSwitch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _jTgbAppStateSwitch.setUI(new BasicButtonUI());
        _jTgbAppStateSwitch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (_jTgbAppStateSwitch.isSelected())
                {
                    _jTgbAppStateSwitch.setBackground(Color.GREEN);
                    _jTgbAppStateSwitch.setText("Running");
                }
                else
                {
                    _jTgbAppStateSwitch.setBackground(Color.RED);
                    _jTgbAppStateSwitch.setText("Stopped");
                }
            }
        });
        
        // jPnlProgramState
        _jPnlProgramState.add(_jTgbAppStateSwitch, GridBagConstraintsBuilder.CreateConstraint(0, 0));
        this.add(_jPnlProgramState, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));

        // jLblCurrentPeriod
        // TODO: remove
        _jLblCurrentPeriod.setText("Rest Period");
        
        // jLblCountDown
        // TODO: remove
        _jLblCountDown.setText("20:00");
        
        // jPnlCurrentPeriod
        _jPnlCurrentPeriod.add(_jLblCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 40)));
        _jPnlCurrentPeriod.add(_jLblCountDown, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 40, 0, 0)));
        this.add(_jPnlCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
        // jBtnHideApp
        _jBtnHideApp.setUI(new BasicButtonUI());
        _jBtnHideApp.setText("Hide App");
        _jBtnHideApp.setPreferredSize(new Dimension(200, 60));
        _jBtnHideApp.setOpaque(false);
        _jBtnHideApp.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        _jBtnHideApp.setForeground(Color.BLACK);
        _jBtnHideApp.addActionListener(this::jBtnHideAppClicked);
        _jBtnHideApp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add(_jBtnHideApp, GridBagConstraintsBuilder.CreateConstraint(0, 2, 1.0, 0.2, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 10, 10, 10)));
        
    }
    
    public JPnlMainScreen(JFrmMain appMainWindow) {
    
        InitializeComponents();
        _appMainWindow = appMainWindow;
        
        // TODO
        // initialize UI lables
        
    }
    
    private void appStateSwitchToggled(ActionEvent e){
        
        // TODO
    }
    
    private void hideApp(){

        _appMainWindow.setVisible(false);
        
    }
    
    private void jBtnHideAppClicked(ActionEvent e){
        
        hideApp();
        
    }

    private static Color lablesBlue = new Color(5, 0, 23);

    private final JFrmMain _appMainWindow;
    private final JPanel _jPnlProgramState = PanelsHelper.CreateTitledJPanel("App Status");
    private final JToggleButton _jTgbAppStateSwitch = new JToggleButton("Running", true);
    private final JPanel _jPnlCurrentPeriod = PanelsHelper.CreateTitledJPanel("Current Period");
    private final JLabel _jLblCurrentPeriod = ComponentFactory.CreateSimpleJLable("", lablesBlue, JLabel.CENTER, new Font("Comic Sans MS", Font.BOLD, 40));
    private final JLabel _jLblCountDown = ComponentFactory.CreateSimpleJLable("", new Color(84, 0, 0), JLabel.CENTER, new Font("Comic Sans MS", Font.BOLD, 40));
    private final JButton _jBtnHideApp = new JButton();
    
}
