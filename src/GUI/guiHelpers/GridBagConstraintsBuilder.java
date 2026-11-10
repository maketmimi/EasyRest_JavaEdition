package GUI.guiHelpers;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public final class GridBagConstraintsBuilder {

    public static GridBagConstraints CreateConstraint(){
        
        return new GridBagConstraints();
        
    }

    public static GridBagConstraints CreateConstraint(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets, int ipadx, int ipady) {

        return new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady);
        
    }
    
    public static GridBagConstraints CreateConstraint(int gridx, int gridy) {

        return new GridBagConstraints(gridx, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
        
    }
    
    public static GridBagConstraints CreateConstraint(int gridx, int gridy, Insets insets) {

        return new GridBagConstraints(gridx, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0);
        
    }
    
    public static GridBagConstraints CreateConstraint(int gridx, int gridy, int ipadx, int ipady, Insets insets) {

        return new GridBagConstraints(gridx, gridy, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, ipadx, ipady);
        
    }
    
    public static GridBagConstraints CreateConstraint(int gridx, int gridy, double weightx, double weighty, int anchor, int fill) {

        return new GridBagConstraints(gridx, gridy, 1, 1, weightx, weighty, anchor, fill, new Insets(0, 0, 0, 0), 0, 0);
        
    }

    public static GridBagConstraints CreateConstraint(int gridx, int gridy, double weightx, double weighty, int anchor, int fill, Insets insets) {

        return new GridBagConstraints(gridx, gridy, 1, 1, weightx, weighty, anchor, fill, insets, 0, 0);
        
    }

    

}
