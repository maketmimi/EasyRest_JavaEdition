package core.events;

import core.EasyRestStatus;

public interface IRunningStateChangedListener {

    public void runningStateChanged(EasyRestStatus sender, EnRunningStateChangeReason reason);
    
}
