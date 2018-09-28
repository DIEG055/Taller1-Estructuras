// Juan Diego Medina Naranjo   jmedinan@unal.edu.co
// Camilo Andres Gil Ballen   cgilb@unal.edu.co

package Punto1;

public abstract class AbstractStack<T> implements Stack<T>{
    
    @Override 
    public abstract int size();
    
    @Override
    public abstract void push(T element);
    
    @Override
    public abstract T pop();
    
    @Override
    public abstract void clear();
    
    @Override
    public abstract void print();
    
    @Override
    public boolean isEmpty(){
        return (size()==0);
    };
    
}
