// Juan Diego Medina Naranjo   jmedinan@unal.edu.co
// Camilo Andres Gil Ballen   cgilb@unal.edu.co

package Punto1;
public interface Stack <T>{
    //Me devuleve el tamaño de mi pila
    int size();
    
    //Me permite añidir un elemento a la STACK
    void push(T element);
    
    //rMe permite retirar un elemento de la STACK
    T pop();
    
    //Me devuelve el elemento N, de la STACK
    T top();
    
    //Me vacia la STACK
    void clear();
    
    //Me imprime la STACK
    void print();
    
    //Me indica si la STACK esta vacia o no
    boolean isEmpty();
    
}
