package GUI.guiHelpers;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class JNumaricUpDown extends JSpinner {

    public JNumaricUpDown(Number initialValue, Comparable<?> minimum, Comparable<?> maximum, Number stepSize) {
    
        this.setModel(new SpinnerNumberModel(initialValue, minimum, maximum, stepSize));

    }

    @Override
    public void setForeground(Color fg) {

        ((JSpinner.DefaultEditor) this.getEditor()).getTextField().setForeground(fg);

    }
    
    public void setHorizontalAlignment(int horizontalAlignment){
        
        ((JSpinner.DefaultEditor) this.getEditor()).getTextField().setHorizontalAlignment(horizontalAlignment);
        
    }
    
}
