package main;

import GUI.JFrmMain;

public class Program {

    public static void main(String[] args) {

        JFrmMain appMainWindow = new JFrmMain();
        
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-silent"))
        {
            // do nothing just keep the app running in the background
        }
        else
        {
            appMainWindow.setVisible(true);
        }
        
    }

}
