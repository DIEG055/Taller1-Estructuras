/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import java.util.Scanner;

/**
 *
 * @author Juan Diego Medina
 */
public class Punto1_Main {

// Punto a------------------------------------------------------------------
//Dado un número n mostrar en consola los números primos menores a n
    public static boolean[] crear_para_criba(int n) {
        /* Creamos el arreglo del tamaño deseado n+1 */
        boolean[] x = new boolean[n + 1];
        /* Iniciamos el arreglo todo en verdadero */
        for (int i = 0; i <= n; i++) {
            x[i] = true;
        };
        /* Fijamos que cero y uno no son primos */
        x[0] = false;
        x[1] = false;
        return x;
    }

    public static boolean[] tacha_multiplo(boolean[] x, int n, int p) {
        for (int i = 2 * p; i <= n; i += p) {
            x[i] = false;
        }
        return x;
    }

    public static boolean[] criba(boolean[] x, int n, int p) {
        if (n == p) {
            return x;
        } else {
            if (x[p]) {
                return criba(tacha_multiplo(x, n, p), n, p + 1);
            } else {
                return criba(x, n, p + 1);
            }
        }
    }

    public static boolean[] criba(boolean[] x, int n) {
        return criba(x, n, 2);
    }

    public static boolean[] criba(int n) {
        return criba(crear_para_criba(n), n);
    }

// Punto b----------------------------------------------------------------------
// Escribir una función que dada dos matrices de n x n calcule la suma y la
// multiplicación.
    public static int[][] sum(int[][] x, int[][] y, int n) {
        int z[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                z[i][j] = x[i][j] + y[i][j];
            }
        }
        return z;
    }

    public static int[][] multiplication(int[][] x, int[][] y, int n) {
        int z[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int aux = 0;
                for (int k = 0; k < n; k++) {
                    aux += x[i][k] * y[k][j];
                }
                z[i][j] = aux;
            }

        }
        return z;
    }

    public static void printm(int[][] x, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((x[i][j]) + " ");
            }
            System.out.println("");
        }
    }

// Punto c----------------------------------------------------------------------
//Escribir una función recursiva que dado un String s calcule la cadena inversa
    public static String reverse(String n, int i) {
        if (n.length() == i) {
            return n;
        } else {
            return reverse(n.substring(i),i++) + n.charAt(0);
        }
    }
    
    public static String reverse(String n){
        return reverse(n,1);
    }
// Punto d----------------------------------------------------------------------
//Escribir una función recursiva que dado un número n calcula la cantidad de
//unos que se encuentran en su representación binaria.

    public static int count(int number, int c) {
        if (number == 0 || number == 1) {
            if (number == 1) {
                c++;
            }
            return c;
        } else {

            if (number % 2 != 0) {
                c++;
            }
            return count(number / 2, c);
        }
    }

    public static int binary_count(int n) {
        return count(n, 0);
    }
    
     
//..............................................................................
//..............................................................................  
//..............................................................................    


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
// punto a

//        int p1 = entrada.nextInt();
//        boolean[] criba = criba(p1);
//        for (int i = 0; i < criba.length; i++) {
//            if (criba[i] == true) {
//                System.out.print((i) + " ");
//            }
//        }
// punto b
//        int n = entrada.nextInt();
//        int[][] m1 = new int[n][n];
//        int[][] m2 = new int[n][n];
//
//        // invento matriz, (DESPUES ARREGLAR)
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                m1[i][j] = j + i;
//                m2[i][j] = j * i;
//            }
//        }
// reviso las matrices
//        printm(m1,n);
//        System.out.println("");
//        printm (m2,n);
//        System.out.println("");
//        int[][] sum = sum(m1, m2, n);
//        int[][] mul = multiplication(m1, m2, n);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print((mul[i][j]) + " ");
//            }
//            System.out.println("");
//        }
// punto c
//        String p3 = entrada.next();
//        System.out.println(reverse(p3));
// punto d
//        int p4 = entrada.nextInt();
//        System.out.println(binary_count(p4));
    }

}
