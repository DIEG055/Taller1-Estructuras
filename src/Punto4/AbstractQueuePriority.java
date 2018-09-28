package Punto4;
//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*Esta clase abstrata implementa la interface Queue con prioridad, la cual la obliga a 
  implementar una serie de metodos. 
  
  Ademas en esta clase definimos, el metodo isEmpty(), el cual funcionara 
  de la misma manera, independiente de la forma que se implemente (arrays o nodos enlazados)
*/
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
    public boolean isEmpty(){
        return (size()==0);
    }
    
    @Override
    public abstract void clear();
    
    @Override
    public abstract void print();
    
    
}
