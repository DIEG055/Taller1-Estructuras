// Juan Diego Medina Naranjo   jmedinan@unal.edu.co
// Camilo Andres Gil Ballen   cgilb@unal.edu.co
package Punto1;
public class MyLinkedStack<T> extends AbstractStack<T>{
    Node<T> top;

    public MyLinkedStack(){
        this.top=null;
    }
    
    
    @Override
    public void push(T element) {
        Node<T> newNode= new Node(element, top);
        top=newNode;
    }
    
    @Override
    public int size(){
        Node<T> auxNode = top;
        int aux=0;
        while(auxNode != null){
           aux++;
           auxNode = auxNode.getDown();
        }    
        return aux;
    }
    
    @Override
    public T pop() {
        if(top==null){
            return null;
        }
        else{
            T auxElement = top.getElement();
            top= top.getDown();
            return auxElement;
        }
    }

    
    @Override
    public T top() {
        if(top==null){
            return null;
        }
        else{
            return top.getElement();
        }    
    }
    
    
    @Override
    public void clear() {
        top=null;
    }

    
    @Override
    public void print() {
       Node<T> auxNode = top;
       while(auxNode != null){
           System.out.println(auxNode.getElement().toString());
           auxNode = auxNode.getDown();
       }
    }

    

    
    
}
