/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;
//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

/**
 *
 * @author cgilb / jmedinan
 */
public class Punto4Main {

    public static void main(String args[]) {
        Person[] persons = new Person[10];
        Person p1 = new Person("Camilo", "Gil", 100001);
        Person p2 = new Person("Camila", "Rodriguez", 100002);
        Person p3 = new Person("Juan", "Garcia", 100003);
        Person p4 = new Person("Juana", "Hernandez", 100004);
        Person p5 = new Person("Carlos", "Ramirez", 100005);
        Person p6 = new Person("Carla", "Pardo", 100006);
        Person p7 = new Person("Antonio", "Santos", 100007);
        Person p8 = new Person("Antonia", "Uribe", 100008);
        Person p9 = new Person("Valentin", "Montoya", 100009);
        Person p10 = new Person("Valentina", "Orozco", 100010);
        
        persons[0]=p1;
        persons[1]=p2;
        persons[2]=p3;
        persons[3]=p4;
        persons[4]=p5;
        persons[5]=p6;
        persons[6]=p7;
        persons[7]=p8;
        persons[8]=p9;
        persons[9]=p10;
        
        //Create ten persons and add to the persons array, for instance Person p1 = new Person(); persons[0] = p1;
        //Generate a random order to enqueue the persons

        int[] permutationArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] randomPermutation = generateRandomPermutation(permutationArray);
        
        System.out.println("ORDEN DE LLEGADA DE LAS PERSONAS AL HOSPITAL");
        MyLinkedQueue<Person> colaEntrada = new MyLinkedQueue<>();
        for (int i = 0; i < randomPermutation.length; i++) {
            Person p = persons[randomPermutation[i]];
            System.out.println(i + ") " + p.toString());
            //Add person p into queue            
            colaEntrada.enqueue(p);
        }
        
        System.out.println("");
        System.out.println("************************************************************************************************************************************************");
        System.out.println("");
        System.out.println("ASIGNACION DE TRIGE A CADA PERSONA");
        
        int tamColaEntrada = colaEntrada.size();
        MyLinkedQueuePriority<Person> colaAtencion = new MyLinkedQueuePriority<>();
        
        for(int i = 0; i< tamColaEntrada; i++){
            int triage = generateRandomInt(1, 10);
            System.out.println(i + ") TRIAGE:" + triage + "  Persona: " + colaEntrada.first());
            colaAtencion.enqueue(colaEntrada.dequeue(), triage);
        }
        
        //Dequeue and assign random triage value for each person in queue
        //After assign triage value enqueue the person in priority queue
        
        
        
        System.out.println("");
        System.out.println("************************************************************************************************************************************************");
        System.out.println("");
        System.out.println("ORDEN DE ATENCION A CADA PERSONA");
        
        int tamColaAtencion = colaAtencion.size();
        
        for(int i=0; i<tamColaAtencion; i++){
            int trige = colaAtencion.maxPriority();
            System.out.println(i+ ") TRIGE:" + trige +"  Persona: " + colaAtencion.dequeue());
        }
        
        //Finally, when all persons are enqueued in the priority queue,
        //start with the dequeue and print the order of output
    }

    private static int generateRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static int[] generateRandomPermutation(int[] originalArray) {
        int aux;
        int numRandom;
        for (int i = 0; i < originalArray.length; i++) {
            numRandom = generateRandomInt(i, originalArray.length - 1);
            aux = originalArray[i];
            originalArray[i] = originalArray[numRandom];
            originalArray[numRandom] = aux;
        }
        return originalArray;
    }
    
    
    

}
