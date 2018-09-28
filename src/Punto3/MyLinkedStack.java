package Punto3;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/*En esta clase realizamos la implemetacion de una Stack, a traves de nodos 
  enlazados, para esto heradamos de la clase AbstractStack, la cual nos proporcionara
  la implementacion de algunos metodos y nos obligara a implementar otros. 
    
  A continuacion se realiza una breve descripcion de la manera en que se implemento
  cada metodo.
*/


public class MyLinkedStack<T> extends AbstractStack<T>{
    private NodeStack<T> top; //Nos referencia el tope o cima de la Stack

    //Constructor de nuestra Stack, siempre inicia vacio
    public MyLinkedStack(){
        this.top=null;
    }
    
    
    //Implementacion del metodo push
    @Override
    public void push(T element) {
        NodeStack<T> newNode= new NodeStack(element, top);
        top=newNode;
    }
    
    //Implementacion del metodo size, nos arroja el tamaño de la Stack
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
    
    //Implementacion del metodo push
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

    //Implementacion del metodo top
    @Override
    public T top() {
        if(top==null){
            return null;
        }
        else{
            return top.getElement();
        }    
    }
    
    //Implementacion del metodo clear
    @Override
    public void clear() {
        top=null;
    }

    //Implementacion del metodo print
    @Override
    public void print() {
       NodeStack<T> auxNode = top;
       while(auxNode != null){
           System.out.println(auxNode.getElement().toString());
           auxNode = auxNode.getDown();
       }
    }

    

    
    
}
