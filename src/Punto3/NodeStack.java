package Punto3;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*Esta clase contiene la estrucutura de un de nodo de una pila o Stack,
  su estructura esta conformanda por T element, y una referencia al nodo
  que esta debajo de el o previo
  
  Ademas tiene un constructor simple y los respestivos getter y setter
    
*/
public class NodeStack<T>{
    private T element; 
    private NodeStack<T> down;
    
    public NodeStack(T element, NodeStack<T> downElement){
        this.element=element;
        this.down=downElement;
    }
    
    public T getElement(){
        return element;
    }
    
    public void setElement(T element) {
        this.element = element;
    }
    public NodeStack<T> getDown() {
        return down;
    }
    
    public void setDown(NodeStack<T> down) {
        this.down = down;
    }
    
}