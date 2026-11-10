package GUI.guiHelpers;

import javax.swing.JTextArea;


public class JMultiLineLable extends JTextArea {

    public JMultiLineLable() {

        this.setOpaque(false);
        this.setEditable(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
    
    }

    
}
