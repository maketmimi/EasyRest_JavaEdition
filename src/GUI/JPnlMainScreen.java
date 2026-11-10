package GUI;

import GUI.guiHelpers.GridBagConstraintsBuilder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicButtonUI;


public class JPnlMainScreen extends JPanel {

    private void InitializeComponents(){
        
        Color lablesBlue = new Color(5, 0, 23);
        Font titlesFont = new Font("Comic Sans MS", Font.BOLD, 30);
        
        // this jpanel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        
        // jTgbAppStateSwitch
        jTgbAppStateSwitch.setPreferredSize(new Dimension(300, 80));
        jTgbAppStateSwitch.setBackground(Color.GREEN);
        jTgbAppStateSwitch.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        jTgbAppStateSwitch.setForeground(Color.WHITE);
        jTgbAppStateSwitch.addActionListener(this::appStateSwitchToggled);
        jTgbAppStateSwitch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTgbAppStateSwitch.setUI(new BasicButtonUI());
        jTgbAppStateSwitch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (jTgbAppStateSwitch.isSelected())
                {
                    jTgbAppStateSwitch.setBackground(Color.GREEN);
                    jTgbAppStateSwitch.setText("Running");
                }
                else
                {
                    jTgbAppStateSwitch.setBackground(Color.RED);
                    jTgbAppStateSwitch.setText("Stopped");
                }
            }
        });
        
        // jPnlProgramState
        jPnlProgramState.setLayout(new GridBagLayout());
        jPnlProgramState.setOpaque(false);
        LineBorder jPnlProgramStateLineBorder = new LineBorder(Color.BLACK, 1);
        TitledBorder jPnlProgramStateBorder = new TitledBorder(jPnlProgramStateLineBorder, "App Status", TitledBorder.LEFT, TitledBorder.TOP, titlesFont, lablesBlue);
        jPnlProgramState.setBorder(jPnlProgramStateBorder);
        jPnlProgramState.add(jTgbAppStateSwitch, GridBagConstraintsBuilder.CreateConstraint(0, 0));
        this.add(jPnlProgramState, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));

        // jLblCurrentPeriod
        jLblCurrentPeriod.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        jLblCurrentPeriod.setForeground(lablesBlue);
        jLblCurrentPeriod.setHorizontalAlignment(JLabel.CENTER);
        // TODO: remove
        jLblCurrentPeriod.setText("Rest Period");
        
        // jLblCountDown
        jLblCountDown.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        jLblCountDown.setForeground(new Color(84, 0, 0));
        jLblCountDown.setHorizontalAlignment(JLabel.CENTER);
        // TODO: remove
        jLblCountDown.setText("20:00");
        
        // jPnlCurrentPeriod
        jPnlCurrentPeriod.setLayout(new GridBagLayout());
        jPnlCurrentPeriod.setOpaque(false);
        LineBorder jPnlCurrentPeriodLineBorder = new LineBorder(Color.BLACK, 1);
        TitledBorder jPnlCurrentPeriodBorder = new TitledBorder(jPnlCurrentPeriodLineBorder, "Current Period", TitledBorder.LEFT, TitledBorder.TOP, titlesFont, lablesBlue);
        jPnlCurrentPeriod.setBorder(jPnlCurrentPeriodBorder);
        jPnlCurrentPeriod.add(jLblCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 40)));
        jPnlCurrentPeriod.add(jLblCountDown, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 40, 0, 0)));
        this.add(jPnlCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
    }
    
    public JPnlMainScreen() {
    
        InitializeComponents();
    
        // TODO
        // initialize UI lables
        
    }
    
    private void appStateSwitchToggled(ActionEvent e){
        
        // TODO
    }

    private final JPanel jPnlProgramState = new JPanel();
    private final JToggleButton jTgbAppStateSwitch = new JToggleButton("Running", true);
    private final JPanel jPnlCurrentPeriod = new JPanel();
    private final JLabel jLblCurrentPeriod = new JLabel();
    private final JLabel jLblCountDown = new JLabel();
    
}
