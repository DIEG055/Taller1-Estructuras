package Punto4;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*Esta interface permite la implementacion de una cola, en ella
  encentran los metodos obligatorios correspondientes a una cola  
*/

public interface Queue<T> {
    //Me devuele el tamaño de la cola
    int size();
    
    //Me agrega un elemento a la cola
    void enqueue(T element);
   
    //Me devuelve y retira el primer elemento de la cola
    T dequeue();
    
    //Me devuelve el primer elemento de la cola
    T first();
    
    //Me dice si la cola esta vacio o no
    boolean isEmpty();
    
    //Me vacia la cola
    void clear();
    
    //Imprime la cola
    void print();
    
}
