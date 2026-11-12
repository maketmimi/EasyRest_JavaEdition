package core.events;

import java.util.ArrayList;
import java.util.function.Consumer;


public abstract class SimpleEvent<listenerType, eventArgsType extends SimpleEventArgs>{

    private final ArrayList<listenerType> _registeredListeners = new ArrayList<listenerType>();

    public SimpleEvent() {

    
    }
    
    public void addListener(listenerType listenerToAdd){
        
        if (listenerToAdd != null)
            _registeredListeners.add(listenerToAdd);
        
    }
    
    public boolean removeListener(listenerType listenerToRemove){
        
        if (listenerToRemove != null)
            return _registeredListeners.remove(listenerToRemove);
        
        return false;
    }
    
    public void fire(eventArgsType eventArgs){

        _registeredListeners.forEach(new Consumer<listenerType>(){
            @Override
            public void accept(listenerType t) {

                fireAction(t, eventArgs);

            }
        });
        
    }
    
    protected abstract void fireAction(listenerType listener, eventArgsType eventArgs);
    
}
