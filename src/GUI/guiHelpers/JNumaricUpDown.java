package GUI.guiHelpers;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class JNumaricUpDown extends JSpinner {

    public JNumaricUpDown(Number initialValue, Comparable<?> minimum, Comparable<?> maximum, Number stepSize) {
    
        this.setModel(new SpinnerNumberModel(initialValue, minimum, maximum, stepSize));

    }

}
