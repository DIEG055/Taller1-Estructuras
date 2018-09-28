package Punto4;

public class MyLinkedQueue<T> extends AbstractQueue<T>{
    private NodeQueue<T> front;
    private NodeQueue<T> back;

    
    
    public MyLinkedQueue(){
        front=null;
        back=null;
    }

    public NodeQueue<T> getFront() {
        return front;
    }

    public void setFront(NodeQueue<T> front) {
        this.front = front;
    }

    public NodeQueue<T> getBack() {
        return back;
    }

    public void setBack(NodeQueue<T> back) {
        this.back = back;
    }
    
    
    
    @Override
    public int size() {
        int contador = 0;
        NodeQueue<T> nodeAux=front;
        while(nodeAux != null){
            contador++;
            nodeAux = nodeAux.getNext();
        }   
        return contador;
    }

    @Override
    public void enqueue(T element) {
        NodeQueue<T> newNode = new NodeQueue<>(element, null);
        if(size() == 0){
            front=newNode;
        }
        else{
            back.setNext(newNode);
        }
        back=newNode;
        
    }

    @Override
    public T dequeue() {
        if(size()==0){
            return null;
        }
        else{
            T elementAux= front.getElement();
            front = front.getNext();
            return elementAux;
        }
        
    }

    @Override
    public T first() {
        if(size()==0){
            return null;
        }
        else{
            return front.getElement();
        }
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void clear() {
        front=null;
        back=null;
    }

    @Override
    public void print() {
        NodeQueue<T> nodeAux= front;
        while(nodeAux != null){
            System.out.println(nodeAux.getElement().toString());
            nodeAux=nodeAux.getNext();
        }
    }
    
}
