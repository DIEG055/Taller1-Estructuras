/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

/**
 *
 * @author Juan Diego Medina
 */
public class Punto2_Main {

    //lineal search
    public static int linalsearch(int n, int[] x) {
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
                rarray[i-lelements] = x[i];
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
        int[] x = {2, 18, 1, 78, 4, 6, 90, 0, 8, 6};
        x = mergesort(x);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
}
