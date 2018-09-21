/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import static java.lang.Math.pow;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Juan Diego Medina
 */
public class Punto2_Main {

    public static Integer randomnumber(int max) {
        return (int) (Math.random() * max);
    }

    public static int[] randomarray(int size,Integer max) {
        int[] x = new int[size];
        //max number
        for (int i = 0; i < size; i++) {
            x[i] = randomnumber(max);
        }
        return x;
    }

    //lineal search
    public static int linealsearch(int n, int[] x) {
        int aux = -1;
        for (int i = 0; i < x.length; i++) {
            if (n == x[i]) {
                aux = i;
                break;
            }
        }
        return aux;
    }

    //bubblesort
    public static int[] bubblesort(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (x[i] > x[j]) {
                    int a = x[i];
                    x[i] = x[j];
                    x[j] = a;
                }
            }
        }
        return x;
    }

    //Mergesort
    public static int[] mergesort(int[] x) {
        // i --> arreglo original
        // j --> arreglo izquierdo
        // k --> arreglo derecho 
        int i, j, k;
        if (x.length > 1) {
            int lelements = x.length / 2;
            int relements = x.length - lelements;
            int[] larray = new int[lelements];
            int[] rarray = new int[relements];

            for (i = 0; i < lelements; i++) {
                larray[i] = x[i];
            }
            for (i = lelements; i < x.length; i++) {
                rarray[i - lelements] = x[i];
            }
            larray = mergesort(larray);
            rarray = mergesort(rarray);
            i = 0;
            j = 0;
            k = 0;
            while (larray.length != j && rarray.length != k) {
                if (larray[j] < rarray[k]) {
                    x[i] = larray[j];
                    j++;
                    i++;
                } else {
                    x[i] = rarray[k];
                    k++;
                    i++;
                }
            }
            while (larray.length != j) {
                x[i] = larray[j];
                j++;
                i++;
            }
            while (rarray.length != k) {
                x[i] = rarray[k];
                k++;
                i++;
            }
        }
        return x;
    }

    public static void main(String[] args) {
//        Scanner entrada = new Scanner(System.in);
//        int size = entrada.nextInt();
//        Hashtable<String, Integer> resultados = new Hashtable<String, Integer>();
        //tiempo
        long inicio = 0;
        long fin = 0;
        long prom = 0;
        long prom1 = 0;
        int i = 8;
        while (prom <= 180000) {
            for (int j = 2; j < 10; j++) {
                int size = ((int) pow(10, i)) * j;
                int[] x = randomarray(size, (int) pow(10, i-1));
                System.out.print((size) + " ");
                prom = 0;
                for (int k = 0; k < 7; k++) {

                    inicio = System.currentTimeMillis();
                    int[] y = mergesort(x);
                    fin = System.currentTimeMillis();
                    prom += (fin - inicio);

                }

                prom = prom / 7;

                if (prom >= 180000) {
                    System.out.println("TIEMPO");
                }
                System.out.print((prom));
                System.out.println("");

            }
            i++;
        }

    }
}
