// Juan Diego Medina Naranjo   jmedinan@unal.edu.co
// Camilo Andres Gil Ballen   cgilb@unal.edu.co
package Punto1;


public class Node<T>{
    private T element; 
    private Node<T> down;
    
    public Node(T element, Node<T> downElement){
        this.element=element;
        this.down=downElement;
    }
    
    public T getElement(){
        return element;
    }
    
    public void setElement(T element) {
        this.element = element;
    }
    public Node<T> getDown() {
        return down;
    }
    
    public void setDown(Node<T> down) {
        this.down = down;
    }
    
}