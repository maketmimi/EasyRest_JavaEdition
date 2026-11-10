package GUI;

import GUI.guiHelpers.ComponentFactory;
import GUI.guiHelpers.GUIConfigs;
import GUI.guiHelpers.GridBagConstraintsBuilder;
import GUI.guiHelpers.JNumaricUpDown;
import GUI.guiHelpers.PanelsHelper;
import core.Period;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



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
        _jPnlChangeCurrentPeriod.setPreferredSize(new Dimension(1, 150));
        this.add(_jPnlChangeCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));

        Font numaricUpDownFont = new Font("Comic Sans MS", Font.BOLD, 30);
        
        // _jNudWorkPeriodDuration
        _jNudWorkPeriodDuration.setFont(numaricUpDownFont);
        _jNudWorkPeriodDuration.setForeground(Color.BLACK);
        _jNudWorkPeriodDuration.setHorizontalAlignment(SwingConstants.CENTER);
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
        
        // _jTxtfWorkPeriodCurrentAlarmSound
        _jTxtfWorkPeriodCurrentAlarmSound.setFont(GUIConfigs.defaultTextFieldsFont);
        _jTxtfWorkPeriodCurrentAlarmSound.setForeground(Color.BLACK);
        _jTxtfWorkPeriodCurrentAlarmSound.setEditable(false);
        _jTxtfWorkPeriodCurrentAlarmSound.setPreferredSize(new Dimension(200, 50));
        _jTxtfWorkPeriodCurrentAlarmSound.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        // TODO remove
        _jTxtfWorkPeriodCurrentAlarmSound.setText("Default Alarm Sound");
        
        // _jBtnWorkPeriodChooseSound
        _jBtnWorkPeriodChooseSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnWorkPeriodChooseSound.setOpaque(false);
        
        // _jBtnWorkPeriodDefaultAlarmSound
        _jBtnWorkPeriodDefaultAlarmSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnWorkPeriodDefaultAlarmSound.setOpaque(false);
        
        // _jPnlWorkPeriodAlarmSound
        _jPnlWorkPeriodAlarmSound.setLayout(new GridBagLayout());
        _jPnlWorkPeriodAlarmSound.setOpaque(false);
        _jPnlWorkPeriodAlarmSound.add(_jLblWorkPeriodCurrentAlarmSound, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(5, 5, 5, 5)));
        _jPnlWorkPeriodAlarmSound.add(_jTxtfWorkPeriodCurrentAlarmSound, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(5, 5, 5, 5)));
        _jPnlWorkPeriodAlarmSound.add(_jBtnWorkPeriodChooseSound, GridBagConstraintsBuilder.CreateConstraint(0, 1, new Insets(5, 5, 5, 5)));
        _jPnlWorkPeriodAlarmSound.add(_jBtnWorkPeriodDefaultAlarmSound, GridBagConstraintsBuilder.CreateConstraint(1, 1, new Insets(5, 5, 5, 5)));
        
        
        // _jPnlWorkPeriodSettings
        _jPnlWorkPeriodSettings.setPreferredSize(new Dimension(1, 350));
        _jPnlWorkPeriodSettings.add(_jPnlWorkDuration, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0)));
        _jPnlWorkPeriodSettings.add(_jPnlWorkAlarmType, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0)));
        _jPnlWorkPeriodSettings.add(_jPnlWorkPeriodAlarmSound, GridBagConstraintsBuilder.CreateConstraint(0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0)));
        this.add(_jPnlWorkPeriodSettings, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
        
        // _jNudRestPeriodDuration
        _jNudRestPeriodDuration.setFont(numaricUpDownFont);
        _jNudRestPeriodDuration.setForeground(Color.BLACK);
        _jNudRestPeriodDuration.setHorizontalAlignment(SwingConstants.CENTER);
        _jNudRestPeriodDuration.setPreferredSize(new Dimension(80, 50));
        
        // _jCmbRestPeriodAlarmType
        _jCmbRestPeriodAlarmType.setEditable(false);
        _jCmbRestPeriodAlarmType.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        _jCmbRestPeriodAlarmType.setForeground(Color.BLACK);
        _jCmbRestPeriodAlarmType.setPreferredSize(new Dimension(200, 40));
        
        // _jPnlRestDuration
        _jPnlRestDuration.setLayout(new GridBagLayout());
        _jPnlRestDuration.setOpaque(false);
        _jPnlRestDuration.add(_jLblRestPeriodDurationCaption, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 10)));
        _jPnlRestDuration.add(_jNudRestPeriodDuration, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 10, 0, 10)));
        _jPnlRestDuration.add(_jLblRestPeriodDurationMinutesCaption, GridBagConstraintsBuilder.CreateConstraint(2, 0, new Insets(0, 10, 0, 0)));
        
        // _jPnlRestAlarmType
        _jPnlRestAlarmType.setLayout(new GridBagLayout());
        _jPnlRestAlarmType.setOpaque(false);
        _jPnlRestAlarmType.add(_jLblRestPeriodAlarmType, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 10)));
        _jPnlRestAlarmType.add(_jCmbRestPeriodAlarmType, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 10, 0, 0)));
        
        // _jTxtfRestPeriodCurrentAlarmSound
        _jTxtfRestPeriodCurrentAlarmSound.setFont(GUIConfigs.defaultTextFieldsFont);
        _jTxtfRestPeriodCurrentAlarmSound.setForeground(Color.BLACK);
        _jTxtfRestPeriodCurrentAlarmSound.setEditable(false);
        _jTxtfRestPeriodCurrentAlarmSound.setPreferredSize(new Dimension(200, 50));
        _jTxtfRestPeriodCurrentAlarmSound.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        // TODO remove
        _jTxtfRestPeriodCurrentAlarmSound.setText("Default Alarm Sound");
        
        // _jBtnRestPeriodChooseSound
        _jBtnRestPeriodChooseSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnRestPeriodChooseSound.setOpaque(false);
        
        // _jBtnRestPeriodDefaultAlarmSound
        _jBtnRestPeriodDefaultAlarmSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnRestPeriodDefaultAlarmSound.setOpaque(false);
        
        // _jPnlRestPeriodAlarmSound
        _jPnlRestPeriodAlarmSound.setLayout(new GridBagLayout());
        _jPnlRestPeriodAlarmSound.setOpaque(false);
        _jPnlRestPeriodAlarmSound.add(_jLblRestPeriodCurrentAlarmSound, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(5, 5, 5, 5)));
        _jPnlRestPeriodAlarmSound.add(_jTxtfRestPeriodCurrentAlarmSound, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(5, 5, 5, 5)));
        _jPnlRestPeriodAlarmSound.add(_jBtnRestPeriodChooseSound, GridBagConstraintsBuilder.CreateConstraint(0, 1, new Insets(5, 5, 5, 5)));
        _jPnlRestPeriodAlarmSound.add(_jBtnRestPeriodDefaultAlarmSound, GridBagConstraintsBuilder.CreateConstraint(1, 1, new Insets(5, 5, 5, 5)));
        
        
        // _jPnlRestPeriodSettings
        _jPnlRestPeriodSettings.setPreferredSize(new Dimension(1, 350));
        _jPnlRestPeriodSettings.add(_jPnlRestDuration, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0)));
        _jPnlRestPeriodSettings.add(_jPnlRestAlarmType, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0)));
        _jPnlRestPeriodSettings.add(_jPnlRestPeriodAlarmSound, GridBagConstraintsBuilder.CreateConstraint(0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0)));
        this.add(_jPnlRestPeriodSettings, GridBagConstraintsBuilder.CreateConstraint(0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
        // _jBtnApplySettings
        _jBtnApplySettings.setForeground(GUIConfigs.lablesBlue);
        _jBtnApplySettings.setOpaque(false);
        this.add(_jBtnApplySettings, GridBagConstraintsBuilder.CreateConstraint(0, 3, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 10, 10, 15)));
        
        
        
    }

    public JPnlSettingsScreen(JFrmMain appMainWindow) {
    
        InitializeComponents();
        _appMainWindow = appMainWindow;
        
    }
    

    private final JFrmMain _appMainWindow;
    
    private final JPanel _jPnlChangeCurrentPeriod = PanelsHelper.CreateTitledJPanel("Change Current Period");
    private final JLabel _jLblChooseCurrentPeriod = ComponentFactory.CreateSimpleJLable("Choose Period:", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    private final JComboBox<Period> _jCmbCurrentPeriod = new JComboBox<>();
    
    
    private final JPanel _jPnlWorkPeriodSettings = PanelsHelper.CreateTitledJPanel("Work Period Settings");
    
    private final JPanel _jPnlWorkDuration = new JPanel();
    
    private final JNumaricUpDown _jNudWorkPeriodDuration = new JNumaricUpDown(1, 1, null, 1);
    private final JLabel _jLblWorkPeriodDurationCaption = ComponentFactory.CreateSimpleJLable("Period Duration:", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    private final JLabel _jLblWorkPeriodDurationMinutesCaption = ComponentFactory.CreateSimpleJLable("Minute(s)", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    
    private final JPanel _jPnlWorkAlarmType = new JPanel();
    
    private final JLabel _jLblWorkPeriodAlarmType = ComponentFactory.CreateSimpleJLable("Alarm Type:", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    private final JComboBox<Period.EnAlarmType> _jCmbWorkPeriodAlarmType = new JComboBox<>(Period.EnAlarmType.values());
    
    private final JPanel _jPnlWorkPeriodAlarmSound = new JPanel();
    
    private final JLabel _jLblWorkPeriodCurrentAlarmSound = ComponentFactory.CreateSimpleJLable("Current Alarm Sound:", Color.BLACK, JLabel.LEFT, new Font("Comic Sans MS", Font.BOLD, 20));
    private final JTextField _jTxtfWorkPeriodCurrentAlarmSound = new JTextField();
    private final JButton _jBtnWorkPeriodChooseSound = ComponentFactory.createSimpleFlatJButton("Choose Sound", new Dimension(200, 50), new Font("Comic Sans MS", Font.BOLD, 20));
    private final JButton _jBtnWorkPeriodDefaultAlarmSound = ComponentFactory.createSimpleFlatJButton("Default Sound", new Dimension(200, 50), new Font("Comic Sans MS", Font.BOLD, 20));
        
    private final JPanel _jPnlRestPeriodSettings = PanelsHelper.CreateTitledJPanel("Rest Period Settings");
    
    private final JPanel _jPnlRestDuration = new JPanel();
    
    private final JNumaricUpDown _jNudRestPeriodDuration = new JNumaricUpDown(1, 1, null, 1);
    private final JLabel _jLblRestPeriodDurationCaption = ComponentFactory.CreateSimpleJLable("Period Duration:", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    private final JLabel _jLblRestPeriodDurationMinutesCaption = ComponentFactory.CreateSimpleJLable("Minute(s)", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    
    private final JPanel _jPnlRestAlarmType = new JPanel();
    
    private final JLabel _jLblRestPeriodAlarmType = ComponentFactory.CreateSimpleJLable("Alarm Type:", Color.BLACK, JLabel.CENTER, GUIConfigs.defaultLablesFont);
    private final JComboBox<Period.EnAlarmType> _jCmbRestPeriodAlarmType = new JComboBox<>(Period.EnAlarmType.values());
    
    private final JPanel _jPnlRestPeriodAlarmSound = new JPanel();
    
    private final JLabel _jLblRestPeriodCurrentAlarmSound = ComponentFactory.CreateSimpleJLable("Current Alarm Sound:", Color.BLACK, JLabel.LEFT, new Font("Comic Sans MS", Font.BOLD, 20));
    private final JTextField _jTxtfRestPeriodCurrentAlarmSound = new JTextField();
    private final JButton _jBtnRestPeriodChooseSound = ComponentFactory.createSimpleFlatJButton("Choose Sound", new Dimension(200, 50), new Font("Comic Sans MS", Font.BOLD, 20));
    private final JButton _jBtnRestPeriodDefaultAlarmSound = ComponentFactory.createSimpleFlatJButton("Default Sound", new Dimension(200, 50), new Font("Comic Sans MS", Font.BOLD, 20));

    
    private final JButton _jBtnApplySettings = ComponentFactory.createSimpleFlatJButton("Apply", new Dimension(150, 60), new Font("Comic Sans MS", Font.BOLD, 30));
    
}
