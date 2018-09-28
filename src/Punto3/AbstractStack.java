package Punto3;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*Esta clase abstrata implementa la interface Stack, la cual la obliga a 
  implementar una serie de metodos. 
  
  Ademas en esta clase definimos, el metodo isEmpty(), el cual funcionara 
  de la misma manera, independiente de la forma que se implemente (arrays o nodos enlazados)
*/

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
