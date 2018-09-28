// Juan Diego Medina Naranjo   jmedinan@unal.edu.co
// Camilo Andres Gil Ballen   cgilb@unal.edu.co
package Punto1;


public class Punto2Main {

    public static void main(String args[]) {
        long inicio = 0;
        long fin = 0;
        int n = 10000;
        int[] searchArray = generateRandomArray(n, -n, n);
        int N = generateRandomInt(-n, n);
        //Start Time
        inicio = System.currentTimeMillis();
        int index = linealSearch(searchArray, N);
        fin = System.currentTimeMillis();
        System.out.println("Lineal Search");
        System.out.println("tam: " + (n) + "   " + "tiempo milisegundos: " + (fin - inicio));
        //End Time

        int[] bubbleArray = generateRandomArray(n, -n, n);
        //Start Time
        inicio = System.currentTimeMillis();
        bubbleSort(bubbleArray);
        fin = System.currentTimeMillis();
        System.out.println("Bubblesort");
        System.out.println("tam: " + (n) + "   " + "tiempo milisegundos: " + (fin - inicio));
        //End Time

        int[] mergeArray = generateRandomArray(n, -n, n);
        //Start Time
        inicio = System.currentTimeMillis();
        mergeSort(mergeArray);
        fin = System.currentTimeMillis();
        System.out.println("MergeSort");
        System.out.println("tam: " + (n) + "   " + "tiempo milisegundos: " + (fin - inicio));
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
        return (int) ((Math.random() * (max - min)) + min);
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

    private static int[] mergeSort(int[] array) {
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
            larray = mergeSort(larray);
            rarray = mergeSort(rarray);
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
        return array;
    }

}
