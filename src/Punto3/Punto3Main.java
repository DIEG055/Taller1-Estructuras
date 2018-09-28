package Punto3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/**
 *
 * @author cgilb / jmedinan
 */
public class Punto3Main {

    public static void main(String args[]) throws IOException, FileNotFoundException {

        String postfixExpression = "5 10 + 2 * 6 12 * +";
        int resolve = resolvePostfixExpression(postfixExpression);
        System.out.println("Resolver Postfix: " + resolve);

        String filePath = "file.txt";
        int numberLine = balancedFile(filePath);
        System.out.println("Line with errors: " + numberLine);

    }

    //Punto A
    private static int resolvePostfixExpression(String s) {
        /*Para iniciar convertimos la cadena s, en una una pila donde nos guardara
          la expresion postfija, esto lo hacemos con ayuda de la funcion toStack();
          
          Para el ejemplo en especifico la pila tendra la forma {5,10,+,2,*,6,12,*,+}
          donde top apunta a 5
         */
        MyLinkedStack<String> stackExpresion = toStack(s);
        MyLinkedStack<Integer> stackResult = new MyLinkedStack<>(); // Esta pila nos guardara los resultados provisionales y el final

        String stringAux; //Nos ayudara a guardar el elemento que va saliendo de la stack
        while (stackExpresion.top() != null) { //Este while se ejecutara hasta la stack que guarda las expresiones este vacia
            stringAux = stackExpresion.pop(); //Extrae el top de la stack y lo guarda

            //Si la expresion, es un operador, extraera dos valores de la stackResult 
            //calculara el resultado y agrega este valor nuevamente a la pila
            if (isOperator(stringAux)) {
                Integer num2 = stackResult.pop();
                Integer num1 = stackResult.pop();
                stackResult.push(operate(stringAux, num1, num2));
            } //Si la expresion no es operador, lo guarda en la stack result
            else {
                stackResult.push(Integer.valueOf(stringAux));
            }
        }

        //Finalmente retornamos el ultimo elemento de la stackResul, el cual sera el resultado
        return stackResult.pop();
    }

    //Esta funcion nos convierte una String, a una pila, los elementos, estaran separados por espacios.
    private static MyLinkedStack<String> toStack(String s) {
        MyLinkedStack<String> auxStack = new MyLinkedStack<>();
        //Este while se ejecutara hasta que el tamaño del string sea 0
        while (firstSpace(s) != -1) {
            auxStack.push(s.substring(0, firstSpace(s)));
            s = s.substring(firstSpace(s) + 1, s.length()); //Modificamos la cadena, suprimendo la parte que acabamos de agragar a la pila
        }
        auxStack.push(s);

        //Inivertimos el orden de la pila
        MyLinkedStack<String> auxStack2 = new MyLinkedStack<>();
        while (auxStack.top() != null) {
            auxStack2.push(auxStack.pop());
        }
        return auxStack2;
    }

    //Esta funcion nos dice, la posicion en la que se encuentra el primer espacio de la pila
    private static int firstSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                return i;
            }
        }
        return -1;
    }

    //Nos dice si un expresion es un operador
    private static boolean isOperator(String s) {
        return ((s.equals("+")) || (s.equals("*")) || (s.equals("-")));
    }

    //Recibe un operador y dos valores, realiza la opracion correspondienete
    private static Integer operate(String operador, Integer num1, Integer num2) {
        if (operador.equals("+")) {
            return num1 + num2;
        } else if (operador.equals("-")) {
            return num1 - num2;
        } else if (operador.equals("*")) {
            return num1 * num2;
        } else {
            return 0;
        }
    }

    
    
    //PUNTO B
    private static int balancedFile(String path) throws FileNotFoundException, IOException {
        MyLinkedStack<Integer> stackContainer = new MyLinkedStack<>(); //Una Stack que nos guardara los corchetes, parentesis, ect
        FileReader lector = new FileReader(path); //El lector
        int linea = 1; //Nos ayudara a saber en que linea esta el lector
        int codCaracter = lector.read(); //Guarda el codigo del caracter que se esta leyendo

        while (codCaracter != -1) { //Se ejecutara hasta acabar el documento
            if (codCaracter == 10) { //El codigo 10, corresponde a un salto de linea
                linea++;
            }
            //Si el caracter es un (, [  o {, lo agrega a la stack
            // ( codigo 40, [ codigo 91, { codigo 123
            else if ((codCaracter == 40) || (codCaracter == 91) || (codCaracter == 123)) {
                stackContainer.push(codCaracter);
            } 
            //A continuacion evalua si el caracter es un ), ], }, en caso de serlo, evalua si en top de la Stack
            //Esta en condorcacia, es dicer, si se esta cerrando lo que se abrio. 
            //Si no lo es, retorna la linea den la que nos encontramos
            
            // ) codigo 41, ] codigo 93, } codigo 125
            else if ((codCaracter == 41)) {
                if (stackContainer.pop() != 40) {
                    stackContainer.print();
                    System.out.println(codCaracter);
                    return linea;
                }
            } 
            else if ((codCaracter == 93)) {
                if (stackContainer.pop() != 91) {
                    stackContainer.print();
                    System.out.println(codCaracter);
                    return linea;
                }
            } 
            else if ((codCaracter == 125)) {
                stackContainer.print();
                if (stackContainer.pop() != 123) {
                    stackContainer.print();
                    System.out.println(codCaracter);
                    return linea;
                }
            }
            //Si no exite inconveniente alguno, hacemos que el lector avance
            codCaracter = lector.read();
        }

        //En caso de llegar al final y la pila estar vacia retorna -1
        if(stackContainer.isEmpty()){
            return -1;
        }
        //En caso contrario, retorna el valor de la ultima linea
        else{
            return linea;
        }
    }

}
