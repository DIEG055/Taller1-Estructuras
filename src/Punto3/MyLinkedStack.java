package Punto3;
public class MyLinkedStack<T> extends AbstractStack<T>{
    NodeStack<T> top;

    public MyLinkedStack(){
        this.top=null;
    }
    
    
    @Override
    public void push(T element) {
        NodeStack<T> newNode= new NodeStack(element, top);
        top=newNode;
    }
    
    @Override
    public int size(){
        NodeStack<T> auxNode = top;
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
       NodeStack<T> auxNode = top;
       while(auxNode != null){
           System.out.println(auxNode.getElement().toString());
           auxNode = auxNode.getDown();
       }
    }

    

    
    
}
