package core.events;


public class GeneralEvent extends SimpleEvent<IGeneralListener, SimpleEventArgs> {

    @Override
    protected void fireAction(IGeneralListener listener, SimpleEventArgs eventArgs) {

        listener.actionPerformed(eventArgs);

    }

}
