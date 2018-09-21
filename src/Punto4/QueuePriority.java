package Punto4;

public interface QueuePriority<T> {
    
    int size();
    
    void enqueue(T element, int priority);
    
    T dequeue();
    
    T first();
    
    boolean isEmpty();
    
    void clear();
    
    void print();
    
    int positionMaxPriority();
}
