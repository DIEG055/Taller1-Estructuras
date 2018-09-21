
package Punto4;

public class MyLinkedQueuePriority<T> extends AbstractQueuePriority<T>{
    private NodePriority<T> front;
    private NodePriority<T> back;
    
    public MyLinkedQueuePriority(){
        front=null;
        back=null;
    }

    public NodePriority<T> getFront() {
        return front;
    }

    public NodePriority<T> getBack() {
        return back;
    }
    
    @Override
    public int size() {
        int contador = 0;
        NodePriority<T> nodeAux=front;
        while(nodeAux != null){
            contador++;
            nodeAux = nodeAux.getNext();
        }   
        return contador;
    }
    
    @Override
    public void enqueue(T element, int priority) {
        NodePriority<T> newNode = new NodePriority<>(element, null,priority);
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
            int positionMaxPriority = positionMaxPriority();
            T elementAux = null;
            if(positionMaxPriority==0){
                elementAux = front.getElement();
                front = front.getNext();
            }
            else{
                NodePriority<T> nodeAux = front;
                for(int i = 1; i<=positionMaxPriority; i++){
                    if(i==positionMaxPriority){
                        elementAux = nodeAux.getNext().getElement();
                        nodeAux.setNext(nodeAux.getNext().getNext());
                    }
                    nodeAux = nodeAux.getNext();
                    
                }
            }
            return elementAux;
        }
    }

    @Override
    public T first() {
        if(size()==0){
            return null;
        }
        else{
            int positionMaxPriority = positionMaxPriority();
            T elementAux = null;
            if(positionMaxPriority==0){
                elementAux = front.getElement();
            }
            else{
                NodePriority<T> nodeAux = front;
                for(int i = 1; i<=positionMaxPriority; i++){
                    if(i==positionMaxPriority){
                        elementAux = nodeAux.getNext().getElement();
                        nodeAux = nodeAux.getNext();
                    }
                    nodeAux = nodeAux.getNext();
                }
            }
            return elementAux;
        }
    }

    @Override
    public boolean isEmpty() {
        return (size()==0);
    }

    @Override
    public void clear() {
        front=null;
        back=null;
    }

    @Override
    public void print() {
        NodePriority<T> nodeAux = front;
        while(nodeAux != null){
            System.out.println("Elemento: " + nodeAux.getElement().toString() + "     Priorodad: " + nodeAux.getPriority());
            nodeAux = nodeAux.getNext();
        }
    }
    
    @Override
    public int positionMaxPriority(){
        int pos=0;
        int priority=0;
        NodePriority<T> nodeAux= front;
        for(int i=0; nodeAux != null; i++){
            if(nodeAux.getPriority() > priority){
                priority=nodeAux.getPriority();
                pos=i;
            }
            nodeAux= nodeAux.getNext();
        }
        return pos;
    }
    
}
