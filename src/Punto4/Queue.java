package Punto4;

public interface Queue<T> {
    
    int size();
    
    void enqueue(T element);
    
    T dequeue();
    
    T first();
    
    boolean isEmpty();
    
    void clear();
    
    void print();
    
}
