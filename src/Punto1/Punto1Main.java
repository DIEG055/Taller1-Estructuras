/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto1;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class Punto1Main {

    public static void main(String args[]) {
        System.out.println("********EJERCICIO 1a********");
        int nPrimes = 100;
        printLessThanNPrime(nPrimes);
        System.out.println("");
        System.out.println("********EJERCICIO 1b********");
        double[][] a = {{2.5, -3.0, 5.0}, {-2.3, 5.0, 3.1}, {9.0, 5.0, -7.5}};
        double[][] b = {{6.5, 2.0, -4.5}, {-6.0, 5.0, 0.6}, {2.8, -4.0, 7.5}};
        double[][] sum = new double[a.length][a.length];
        double[][] mult = new double[a.length][b.length];
        operationWithMatrix(a, b, sum, mult);
        System.out.println("Suma: " + Arrays.toString(sum));
        System.out.println("Multiplicación: " + Arrays.toString(mult));
        System.out.println("");
        System.out.println("********EJERCICIO 1c********");
        String reverse = reverseString("Estructuras de Datos");
        System.out.println("Reverse String: " + reverse);
        System.out.println("");
        System.out.println("********EJERCICIO 1d********");
        int nBinary = 87;
        int numberOnes = countOnesInBinary(nBinary);
        System.out.println("Number of Ones: " + numberOnes);
    }

// Punto a------------------------------------------------------------------
//Dado un número n mostrar en consola los números primos menores a n
    private  static boolean[] crear_para_criba(int n) {
        boolean[] x = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            x[i] = true;
        };
        x[0] = false;
        x[1] = false;
        return x;
    }

    private  static boolean[] tacha_multiplo(boolean[] x, int n, int p) {
        for (int i = 2 * p; i <= n; i += p) {
            x[i] = false;
        }
        return x;
    }

    private  static boolean[] criba(boolean[] x, int n, int p) {
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

    private  static boolean[] criba(boolean[] x, int n) {
        return criba(x, n, 2);
    }

    private  static void printLessThanNPrime(int n) {
        boolean[]x=criba(crear_para_criba(n), n);
        for (int i = 0; i < x.length; i++) {
            if(x[i]){
                System.out.print(i+" ");
            }
        }
 
    }
// Punto b----------------------------------------------------------------------
// Escribir una función que dada dos matrices de n x n calcule la suma y la
// multiplicación.

    private static void operationWithMatrix(double[][] a, double[][] b, double[][] sum, double[][] mult) {
        //sum 
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = a[i][j] + b[i][j];
                int aux = 0;
                for (int k = 0; k < n; k++) {
                    aux += a[i][k] * b[k][j];
                }
                mult[i][j] = aux;
            }
        }
    }
// Punto c----------------------------------------------------------------------
//Escribir una función recursiva que dado un String s calcule la cadena inversa

    private static String reverseString(String s, int i) {
        if (s.length() == i) {
            return s;
        } else {
            return reverseString(s.substring(i), i++) + s.charAt(0);
        }
    }

    private static String reverseString(String s) {
        return reverseString(s, 1);
    }
// Punto d----------------------------------------------------------------------
//Escribir una función recursiva que dado un número n calcula la cantidad de
//unos que se encuentran en su representación binaria.

    private static int countOnesInBinary(int number, int c) {
        if (number == 0 || number == 1) {
            if (number == 1) {
                c++;
            }
            return c;
        } else {

            if (number % 2 != 0) {
                c++;
            }
            return countOnesInBinary(number / 2, c);
        }
    }

    private static int countOnesInBinary(int n) {
        return countOnesInBinary(n, 0);
    }

}
