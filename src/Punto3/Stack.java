package Punto3;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*Esta interface permite la implementacion de una pila o Stack, en ella
  encentran los metodos obligatorios correspondientes a una Stack   
*/

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
