package Punto4;

public abstract class AbstractQueuePriority<T> implements QueuePriority<T> {
    @Override
    public abstract int size();
    
    @Override
    public abstract void enqueue(T element, int priority);
    
    @Override
    public abstract T dequeue();
    
    @Override
    public abstract T first();
    
    @Override
    public abstract boolean isEmpty();
    
    @Override
    public abstract void clear();
    
    @Override
    public abstract void print();
    
    @Override
    public abstract int positionMaxPriority();
}
