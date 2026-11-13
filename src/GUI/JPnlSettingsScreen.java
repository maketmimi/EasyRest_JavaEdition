package GUI;

import GUI.guiHelpers.ComponentFactory;
import GUI.guiHelpers.GUIConfigs;
import GUI.guiHelpers.GridBagConstraintsBuilder;
import GUI.guiHelpers.JNumaricUpDown;
import GUI.guiHelpers.PanelsHelper;
import core.Configs;
import core.Period;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.nio.file.Path;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import core.helpers.soundHelpers.SoundHelper;


public class JPnlSettingsScreen extends JPanel {

    
    private void initialize_jPnlChangeCurrentPeriod(){
        
        // jCmbCurrentPeriod
        _jCmbCurrentPeriod.setEditable(false);
        _jCmbCurrentPeriod.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        _jCmbCurrentPeriod.setForeground(Color.BLACK);
        _jCmbCurrentPeriod.setPreferredSize(new Dimension(250, 50));
        _jCmbCurrentPeriod.addItem(_appMainWindow.getEasyRestStatus().getWorkPeriod());
        _jCmbCurrentPeriod.addItem(_appMainWindow.getEasyRestStatus().getRestPeriod());
        
        // jPnlChangeCurrentPeriod
        _jPnlChangeCurrentPeriod.add(_jLblChooseCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, new Insets(0, 0, 0, 10)));
        _jPnlChangeCurrentPeriod.add(_jCmbCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(1, 0, new Insets(0, 10, 0, 0)));
        _jPnlChangeCurrentPeriod.setPreferredSize(new Dimension(1, 150));
        
    }
    
    private void initialize_jPnlWorkPeriodSettings(){
        
        // _jNudWorkPeriodDuration
        _jNudWorkPeriodDuration.setFont(GUIConfigs.numaricUpDownFont);
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
        
        // _jBtnWorkPeriodChooseSound
        _jBtnWorkPeriodChooseSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnWorkPeriodChooseSound.setOpaque(false);
        _jBtnWorkPeriodChooseSound.addActionListener(this::_jBtnChooseSoundClicked);
        
        // _jBtnWorkPeriodDefaultAlarmSound
        _jBtnWorkPeriodDefaultAlarmSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnWorkPeriodDefaultAlarmSound.setOpaque(false);
        _jBtnWorkPeriodDefaultAlarmSound.addActionListener(this::_jBtnDefaultSoundClicked);
        
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
        
    }
    
    private void initialize_jPnlRestPeriodSettings(){
        
        // _jNudRestPeriodDuration
        _jNudRestPeriodDuration.setFont(GUIConfigs.numaricUpDownFont);
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
        
        // _jBtnRestPeriodChooseSound
        _jBtnRestPeriodChooseSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnRestPeriodChooseSound.setOpaque(false);
        _jBtnRestPeriodChooseSound.addActionListener(this::_jBtnChooseSoundClicked);
        
        // _jBtnRestPeriodDefaultAlarmSound
        _jBtnRestPeriodDefaultAlarmSound.setForeground(GUIConfigs.lablesBlue);
        _jBtnRestPeriodDefaultAlarmSound.setOpaque(false);
        _jBtnRestPeriodDefaultAlarmSound.addActionListener(this::_jBtnDefaultSoundClicked);
        
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
        
    }
    
    private void initialize_jBtnApplySettings(){
        
        _jBtnApplySettings.setForeground(GUIConfigs.lablesBlue);
        _jBtnApplySettings.setOpaque(false);
        _jBtnApplySettings.addActionListener(this::_jBtnApplySettingsClicked);
        
    }
    
    private void initialize_jFchChooseAlarmSound(){
        
        _jFchChooseAlarmSound.setDialogTitle("EasyRest JE - Choose alarm sound");
        _jFchChooseAlarmSound.setAcceptAllFileFilterUsed(false);
        _jFchChooseAlarmSound.setFileFilter(new FileNameExtensionFilter("WAV audio files", "wav", "WAV"));
        
    }
    
    private void initializeComponents(){
               
        // this jpanel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);
        
        // _jPnlChangeCurrentPeriod
        initialize_jPnlChangeCurrentPeriod();
        this.add(_jPnlChangeCurrentPeriod, GridBagConstraintsBuilder.CreateConstraint(0, 0, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));

        
        // _jPnlWorkPeriodSettings
        initialize_jPnlWorkPeriodSettings();
        this.add(_jPnlWorkPeriodSettings, GridBagConstraintsBuilder.CreateConstraint(0, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
        // _jPnlRestPeriodSettings
        initialize_jPnlRestPeriodSettings();
        this.add(_jPnlRestPeriodSettings, GridBagConstraintsBuilder.CreateConstraint(0, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10)));
        
        // _jFchChooseAlarmSound
        initialize_jFchChooseAlarmSound();
        
        // _jBtnApplySettings
        initialize_jBtnApplySettings();
        this.add(_jBtnApplySettings, GridBagConstraintsBuilder.CreateConstraint(0, 3, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 10, 10, 15)));
        
    }

    public JPnlSettingsScreen(JFrmMain appMainWindow) {
    
        _appMainWindow = appMainWindow;
        initializeComponents();
        
    }
    
    private void update_jCmbCurrentPeriod(){
        
        _jCmbCurrentPeriod.setSelectedItem(_appMainWindow.getEasyRestStatus().getCurrentPeriod());
        
    }
    
    private void update_jPnlWorkPeriodSettings(){
        
        _jNudWorkPeriodDuration.setValue(_appMainWindow.getEasyRestStatus().getWorkPeriod().getDuration().toMinutes());
        _jCmbWorkPeriodAlarmType.setSelectedItem(_appMainWindow.getEasyRestStatus().getWorkPeriod().getAlarmType());
        setWorkPeriodAlarmSoundPath(_appMainWindow.getEasyRestStatus().getWorkPeriod().getAlarmSoundPath());
        
    }
    
    private void update_jPnlRestPeriodSettings(){
        
        _jNudRestPeriodDuration.setValue(_appMainWindow.getEasyRestStatus().getRestPeriod().getDuration().toMinutes());
        _jCmbRestPeriodAlarmType.setSelectedItem(_appMainWindow.getEasyRestStatus().getRestPeriod().getAlarmType());
        setRestPeriodAlarmSoundPath(_appMainWindow.getEasyRestStatus().getRestPeriod().getAlarmSoundPath());
        
    }
    
    public void updateSettingsScreenUI(){
        
        update_jCmbCurrentPeriod();
        update_jPnlWorkPeriodSettings();
        update_jPnlRestPeriodSettings();
        
    }
    
    private void applySettings(){
        
        _appMainWindow.getEasyRestStatus().setCurrentPeriod((Period) _jCmbCurrentPeriod.getSelectedItem());
        
        _appMainWindow.getEasyRestStatus().getWorkPeriod().setDuration(Duration.ofMinutes(((Number)_jNudWorkPeriodDuration.getValue()).longValue()));
        _appMainWindow.getEasyRestStatus().getWorkPeriod().setAlarmType((Period.EnAlarmType) _jCmbWorkPeriodAlarmType.getSelectedItem());
        _appMainWindow.getEasyRestStatus().getWorkPeriod().setAlarmSoundPath(getWorkPeriodAlarmSoundPath());
        
        _appMainWindow.getEasyRestStatus().getRestPeriod().setDuration(Duration.ofMinutes(((Number)_jNudRestPeriodDuration.getValue()).longValue()));
        _appMainWindow.getEasyRestStatus().getRestPeriod().setAlarmType((Period.EnAlarmType) _jCmbRestPeriodAlarmType.getSelectedItem());
        _appMainWindow.getEasyRestStatus().getRestPeriod().setAlarmSoundPath(getRestPeriodAlarmSoundPath());
        
        if (_appMainWindow.getEasyRestStatus().saveToFile(Configs.easyRestStatusFilePath))
        {
            JOptionPane.showMessageDialog(_appMainWindow, "Settings saved sucessfully.", "Done", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(_appMainWindow, "Cannot save settings!.", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
    private void _jBtnApplySettingsClicked(ActionEvent e){
        
        applySettings();
        
    }
    
    private void _jBtnDefaultSoundClicked(ActionEvent e){
        
        if (e.getSource() == _jBtnWorkPeriodDefaultAlarmSound)
            setWorkPeriodAlarmSoundPath(Configs.defaultAlarmSoundPath);
        else if (e.getSource() == _jBtnRestPeriodDefaultAlarmSound)
            setRestPeriodAlarmSoundPath(Configs.defaultAlarmSoundPath);
        
    }
    
    private boolean checkAudioFile(String fileName){
        
        if (SoundHelper.isAudioFileSupported(fileName))
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(_appMainWindow, "Ops... this audio file is not supported!", "Not supported audio file!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
    }
    
    private void _jBtnChooseSoundClicked(ActionEvent e){
        
        if (_jFchChooseAlarmSound.showOpenDialog(_appMainWindow) == JFileChooser.APPROVE_OPTION)
        {
            String selectedFilePath = _jFchChooseAlarmSound.getSelectedFile().getAbsolutePath();
            
            if (!checkAudioFile(selectedFilePath))
                return;
            
            if (e.getSource() == _jBtnWorkPeriodChooseSound)
            {
                setWorkPeriodAlarmSoundPath(selectedFilePath);
            }
            else if (e.getSource() == _jBtnRestPeriodChooseSound)
            {
                setRestPeriodAlarmSoundPath(selectedFilePath);
            }
        }
        
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
    private String _workPeriodAlarmSoundPath = null;
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
    private String _restPeriodAlarmSoundPath = null;
    private final JButton _jBtnRestPeriodChooseSound = ComponentFactory.createSimpleFlatJButton("Choose Sound", new Dimension(200, 50), new Font("Comic Sans MS", Font.BOLD, 20));
    private final JButton _jBtnRestPeriodDefaultAlarmSound = ComponentFactory.createSimpleFlatJButton("Default Sound", new Dimension(200, 50), new Font("Comic Sans MS", Font.BOLD, 20));

    private final JFileChooser _jFchChooseAlarmSound = new JFileChooser();
    
    private final JButton _jBtnApplySettings = ComponentFactory.createSimpleFlatJButton("Apply", new Dimension(150, 60), new Font("Comic Sans MS", Font.BOLD, 30));

    
    public String getWorkPeriodAlarmSoundPath() {
        return _workPeriodAlarmSoundPath;
    }

    public void setWorkPeriodAlarmSoundPath(String _workPeriodAlarmSoundPath) {
        this._workPeriodAlarmSoundPath = _workPeriodAlarmSoundPath;
        _jTxtfWorkPeriodCurrentAlarmSound.setText(Path.of(_workPeriodAlarmSoundPath).getFileName().toString());
    }

    public String getRestPeriodAlarmSoundPath() {
        return _restPeriodAlarmSoundPath;
    }

    public void setRestPeriodAlarmSoundPath(String _restPeriodAlarmSoundPath) {
        this._restPeriodAlarmSoundPath = _restPeriodAlarmSoundPath;
        _jTxtfRestPeriodCurrentAlarmSound.setText(Path.of(_restPeriodAlarmSoundPath).getFileName().toString());
    }
    
    
    
    
}
