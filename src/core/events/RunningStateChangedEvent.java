package core.events;


public class RunningStateChangedEvent extends SimpleEvent<IRunningStateChangedListener, RunningStateChangedEventArgs> {

    @Override
    protected void fireAction(IRunningStateChangedListener listener, RunningStateChangedEventArgs eventArgs) {

        listener.runningStateChanged(eventArgs);

    }
    
}
