/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import static Punto1.Punto2_Main.mergesort;
import static Punto1.Punto2_Main.randomnumber;

/**
 *
 * @author jccas
 */
public class Punto2Main {

    public static void main(String args[]) {
        int n = 10;
        int[] searchArray = generateRandomArray(n, -n, n);
        int N = generateRandomInt(-n, n);
        //Start Time
        int index = linealSearch(searchArray, N);
        //End Time

        int[] bubbleArray = generateRandomArray(n, -n, n);
        //Start Time
        bubbleSort(bubbleArray);
        //End Time

        int[] mergeArray = generateRandomArray(n, -n, n);
        //Start Time
        mergeSort(mergeArray);
        //End Time

    }

    private static int[] generateRandomArray(int n, int min, int max) {
        int[] x = new int[n];
        //max number
        for (int i = 0; i < n; i++) {
            x[i] = generateRandomInt(min, max);
        }
        return x;
    }

    private static int generateRandomInt(int min, int max) {
        return (int) (Math.random() * max) + min;
    }

    private static int linealSearch(int[] array, int N) {
        int aux = -1;
        for (int i = 0; i < array.length; i++) {
            if (N == array[i]) {
                aux = i;
                break;
            }
        }
        return aux;
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
    }

    private static void mergeSort(int[] array) {
       // i --> arreglo original
        // j --> arreglo izquierdo
        // k --> arreglo derecho 
        int i, j, k;
        if (array.length > 1) {
            int lelements = array.length / 2;
            int relements = array.length - lelements;
            int[] larray = new int[lelements];
            int[] rarray = new int[relements];

            for (i = 0; i < lelements; i++) {
                larray[i] = array[i];
            }
            for (i = lelements; i < array.length; i++) {
                rarray[i - lelements] = array[i];
            }
            larray = mergesort(larray);
            rarray = mergesort(rarray);
            i = 0;
            j = 0;
            k = 0;
            while (larray.length != j && rarray.length != k) {
                if (larray[j] < rarray[k]) {
                    array[i] = larray[j];
                    j++;
                    i++;
                } else {
                    array[i] = rarray[k];
                    k++;
                    i++;
                }
            }
            while (larray.length != j) {
                array[i] = larray[j];
                j++;
                i++;
            }
            while (rarray.length != k) {
                array[i] = rarray[k];
                k++;
                i++;
            }
        }
    }

}
