package core.events;


public class RunningStateChangedEventArgs extends SimpleEventArgs {

    private final EnRunningStateChangeReason _reason;
    
    public RunningStateChangedEventArgs(Object source, EnRunningStateChangeReason reason) {
        super(source);
    
        _reason = reason;
    
    }

    public EnRunningStateChangeReason getReason() {
        return _reason;
    }

}
