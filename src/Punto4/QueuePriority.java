package Punto4;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*Esta interface permite la implementacion de una cola con prioridad, en ella
  encentran los metodos obligatorios correspondientes a una cola con prioridad 
*/

public interface QueuePriority<T> {
    //Me devuele el tamaño de la cola 
    int size();
    
    //Me agrega un elemento a la cola
    void enqueue(T element, int priority);
    
    //Me devuelve y retira el elemento con mas prioridad de la cola
    T dequeue();
    
    //Me devuelve el elemento con mas prioridad de la cola
    T first();
    
    //Me dice si la cola esta vacio o no
    boolean isEmpty();
    
    //Me vacia la cola
    void clear();
    
    //Imprime la cola
    void print();
    
}
