package GUI;

import GUI.guiHelpers.ComponentFactory;
import GUI.guiHelpers.GridBagConstraintsBuilder;
import GUI.guiHelpers.JNumaricUpDown;
import GUI.guiHelpers.PanelsHelper;
import core.Period;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.Duration;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class JPnlSettingsScreen extends JPanel {

    private void InitializeComponents(){
               
        // this jpanel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        
        // jCmbCurrentPeriod
        _jCmbCurrentPeriod.setEditable(false);
        _jCmbCurrentPeriod.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        _jCmbCurrentPeriod.setForeground(Color.BLACK);
        _jCmbCurrentPeriod.setPreferredSize(new Dimension(250, 50));
        // TODO remove
        _jCmbCurrentPeriod.addItem(new Period("Rest Period", "", Duration.ZERO, Period.EnAlarmType.SoundOnly, null));
        _jCmbCurrentPeriod.addItem(new Period("Work Period", "", Duration.ZERO, Period.EnAlarmType.SoundOnly, null));
        
        
        // jPnlChangeCurrentPeriod
        _jPnlChangeCurrentPeriod.add(_jLblChooseCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 10)));
        _jPnlChangeCurrentPeriod.add(_jCmbCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 10, 0, 0)));
        _jPnlChangeCurrentPeriod.setPreferredSize(new Dimension(1, 200));
        this.add(_jPnlChangeCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));

        Font numaricUpDownFont = new Font("Comic Sans MS", Font.BOLD, 30);
        
        // _jNudWorkPeriodDuration
        _jNudWorkPeriodDuration.setForeground(Color.BLACK);
        _jNudWorkPeriodDuration.setFont(numaricUpDownFont);
        _jNudWorkPeriodDuration.setPreferredSize(new Dimension(80, 50));
        
        // _jCmbWorkPeriodAlarmType
        _jCmbWorkPeriodAlarmType.setEditable(false);
        _jCmbWorkPeriodAlarmType.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        _jCmbWorkPeriodAlarmType.setForeground(Color.BLACK);
        _jCmbWorkPeriodAlarmType.setPreferredSize(new Dimension(200, 40));
        
        // _jPnlWorkDuration
        _jPnlWorkDuration.setLayout(new GridBagLayout());
        _jPnlWorkDuration.setOpaque(false);
        _jPnlWorkDuration.add(_jLblWorkPeriodDurationCaption, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 10)));
        _jPnlWorkDuration.add(_jNudWorkPeriodDuration, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 10, 0, 10)));
        _jPnlWorkDuration.add(_jLblWorkPeriodDurationMinutesCaption, GridBagConstraintsBuilder.CreateConstraint(2, 0, new Insets(0, 10, 0, 0)));
        
        // _jPnlWorkAlarmType
        _jPnlWorkAlarmType.setLayout(new GridBagLayout());
        _jPnlWorkAlarmType.setOpaque(false);
        _jPnlWorkAlarmType.add(_jLblWorkPeriodAlarmType, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 10)));
        _jPnlWorkAlarmType.add(_jCmbWorkPeriodAlarmType, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 10, 0, 0)));
        
        
        // _jPnlWorkPeriodSettings
        _jPnlWorkPeriodSettings.setPreferredSize(new Dimension(1, 200));
        _jPnlWorkPeriodSettings.add(_jPnlWorkDuration, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5)));
        _jPnlWorkPeriodSettings.add(_jPnlWorkAlarmType, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5)));
        
        this.add(_jPnlWorkPeriodSettings, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
    }

    public JPnlSettingsScreen(JFrmMain appMainWindow) {
    
        InitializeComponents();
        _appMainWindow = appMainWindow;
        
    }
    

    private static Font defaultLablesFont = new Font("Comic Sans MS", Font.PLAIN, 30);
    
    private final JFrmMain _appMainWindow;
    
    private final JPanel _jPnlChangeCurrentPeriod = PanelsHelper.CreateTitledJPanel("Change Current Period");
    private final JLabel _jLblChooseCurrentPeriod = ComponentFactory.CreateSimpleJLable("Choose Period:", Color.BLACK, JLabel.CENTER, defaultLablesFont);
    private final JComboBox<Period> _jCmbCurrentPeriod = new JComboBox<>();
    
    
    private final JPanel _jPnlWorkPeriodSettings = PanelsHelper.CreateTitledJPanel("Work Period Settings");
    
    private final JPanel _jPnlWorkDuration = new JPanel();
    
    private final JNumaricUpDown _jNudWorkPeriodDuration = new JNumaricUpDown(1, 1, null, 1);
    private final JLabel _jLblWorkPeriodDurationCaption = ComponentFactory.CreateSimpleJLable("Period Duration:", Color.BLACK, JLabel.CENTER, defaultLablesFont);
    private final JLabel _jLblWorkPeriodDurationMinutesCaption = ComponentFactory.CreateSimpleJLable("Minute(s)", Color.BLACK, JLabel.CENTER, defaultLablesFont);
    
    private final JPanel _jPnlWorkAlarmType = new JPanel();
    
    private final JLabel _jLblWorkPeriodAlarmType = ComponentFactory.CreateSimpleJLable("Alarm Type:", Color.BLACK, JLabel.CENTER, defaultLablesFont);
    private final JComboBox<Period.EnAlarmType> _jCmbWorkPeriodAlarmType = new JComboBox<>(Period.EnAlarmType.values());
    
}
