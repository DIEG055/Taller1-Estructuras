package Punto4;
//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*En esta clase realizamos la implemetacion de una Queue, a traves de nodos 
  enlazados, para esto heradamos de la clase AbstractQueue, la cual nos proporcionara
  la implementacion de algunos metodos y nos obligara a implementar otros. 
    
  A continuacion se realiza una breve descripcion de la manera en que se implemento
  cada metodo.
*/

public class MyLinkedQueue<T> extends AbstractQueue<T>{
    private NodeQueue<T> front; //Refrencia al inicio de la cola
    private NodeQueue<T> back;  //Refrencia al final de la cola

    
    //Constructor basico
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
