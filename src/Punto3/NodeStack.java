package Punto3;


public class NodeStack<T>{
    private T element; 
    private NodeStack<T> down;
    
    public NodeStack(T element, NodeStack<T> downElement){
        this.element=element;
        this.down=downElement;
    }
    
    public T getElement(){
        return element;
    }
    
    public void setElement(T element) {
        this.element = element;
    }
    public NodeStack<T> getDown() {
        return down;
    }
    
    public void setDown(NodeStack<T> down) {
        this.down = down;
    }
    
}