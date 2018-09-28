package Punto4;

public class NodeQueue<T> {
    private T element;
    private NodeQueue<T> next;

    public NodeQueue(T element, NodeQueue<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodeQueue<T> getNext() {
        return next;
    }

    public void setNext(NodeQueue<T> next) {
        this.next = next;
    }
    
    
    
}
