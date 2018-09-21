package Punto4;

public abstract class AbstractQueue<T> implements Queue<T>{
    
    @Override
    public abstract int size();
    
    @Override
    public abstract void enqueue(T element);
    
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
}
