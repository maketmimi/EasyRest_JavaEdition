package core.events;


public class SimpleEventArgs {

    private Object _source = null;

    public Object getSource() {
        return _source;
    }

    public void setSource(Object _source) {
        this._source = _source;
    }

    public SimpleEventArgs(Object source) {
        
        _source = source;
        
    }
    
}
