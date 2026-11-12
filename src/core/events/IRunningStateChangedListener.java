package core.events;

import core.EasyRestStatus;

public interface IRunningStateChangedListener {

    public void runningStateChanged(RunningStateChangedEventArgs eventArgs);
    
}
