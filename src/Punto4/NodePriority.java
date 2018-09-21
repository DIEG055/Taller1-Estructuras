package Punto4;


public class NodePriority<T> {
    private T element;
    private NodePriority<T> next;
    private int priority;

    public NodePriority(T element, NodePriority<T> next, int priority) {
        this.element = element;
        this.next = next;
        this.priority=priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodePriority<T> getNext() {
        return next;
    }

    public void setNext(NodePriority<T> next) {
        this.next = next;
    }
    
}
