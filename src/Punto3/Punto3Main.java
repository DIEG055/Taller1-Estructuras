package Punto3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jccas
 */
public class Punto3Main {
    
    public static void main(String args[]) throws IOException, FileNotFoundException
    {        
       
        String postfixExpression = "5 10 + 2 * 6 12 * +";
        int resolve = resolvePostfixExpression(postfixExpression);
        System.out.println("Resolver Postfix: " + resolve);
        
        
        String filePath = "file.txt";
        int numberLine = balancedFile(filePath);
        System.out.println("Line with errors: " + numberLine);
        
        
    }
    
    
    //Punto A
    private static int resolvePostfixExpression(String s)
    {
        MyLinkedStack<String> stackContainer= toStack(s);
        MyLinkedStack<Integer> stackAux= new MyLinkedStack<>();
        
        String stringAux;
        while(stackContainer.top() != null){
            stringAux = stackContainer.pop();
            
            if(isOperator(stringAux)){
                Integer num2= stackAux.pop();
                Integer num1= stackAux.pop();
                stackAux.push(operate(stringAux, num1, num2));
            }
            
            else{
                stackAux.push(Integer.valueOf(stringAux));
            }
        }
        
        return stackAux.pop();
    }
    
    private static MyLinkedStack<String> toStack(String s){
        MyLinkedStack<String> auxStack = new MyLinkedStack<>();
        while(firstSpace(s) != -1){
            auxStack.push(s.substring(0,firstSpace(s)));
            s=s.substring(firstSpace(s)+1, s.length());
        }
        auxStack.push(s);
        
        
        //Inivertimos el orden de la pila
        MyLinkedStack<String> auxStack2 = new MyLinkedStack<>();
        while(auxStack.top() != null){
            auxStack2.push(auxStack.pop());
        }
        return auxStack2;
    }
    
   private static int firstSpace(String s){
       for(int i=0; i<s.length(); i++){
           if(s.charAt(i) == ' '){
               return i;
           }
       }
       return -1;
   }
    
   private static boolean isOperator(String s){
       return ( (s.equals("+")) || (s.equals("*")) || (s.equals("-")) );
   }
    
   private static Integer operate(String operador, Integer num1, Integer num2){
       if(operador.equals("+")){
           return num1 + num2;
       }
       else if(operador.equals("-")){
           return num1 - num2;
       }
       else if(operador.equals("*")){
           return num1 * num2;
       }
       else{
           return 0;
       }
   } 
            
            
    //Punto B
    private static int balancedFile(String path) throws FileNotFoundException, IOException
    {
        MyLinkedStack<Integer> stackContainer = new MyLinkedStack<>();
        FileReader lector=new FileReader("file.txt");
        int linea=1;
        int codCaracter= lector.read();
        
        while(codCaracter != -1){
            System.out.print((char)codCaracter);
            if(codCaracter == 10){ linea ++;}
            else if( (codCaracter==40) || (codCaracter==91) || (codCaracter==123)){
                stackContainer.push(codCaracter);
            }
            
            else if( (codCaracter == 41)){
                if(stackContainer.pop() != 40){
                    stackContainer.print();
                    System.out.println(codCaracter);
                    return linea;
                }
            }
            
            else if( (codCaracter == 93)){
                if(stackContainer.pop() != 91){
                    stackContainer.print();
                    System.out.println(codCaracter);
                    return linea;
                }
            }
            
            else if( (codCaracter == 125)){
                stackContainer.print();
                if(stackContainer.pop() != 123){
                    stackContainer.print();
                    System.out.println(codCaracter);
                    return linea;
                }
            }
            
            codCaracter = lector.read();
        }
        
        //Your code here
        return -1;        
    }
    
}
