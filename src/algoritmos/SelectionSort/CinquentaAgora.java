package algoritmos.SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class CinquentaAgora {
    public static void main(String[] args) {
        int[] lista_500 = generateRandomArray(500, 1, 500);
//        int[] lista_5000 = generateRandomArray(5000, 1, 100000);
        int[] lista_com_50000 = generateRandomArray(50000, 1, 100000);
        int[] m = {1,4,2,5};

//        selectionSort(lista_com_50000,"desc");
//        insertionSort(lista_500,"asc");
//        bubbleSort(m,"desc")

       System.out.println(Arrays.toString(quickSort(m,0,m.length-1,"asc")));

    }
    public  static  int[] bubbleSort(int[] lista, String flug){
        if(flug =="asc") {


            boolean troca;
            for (int i = 0; i < lista.length; i++) {
                troca = false;
                for (int j = 0; j < lista.length - 1; j++) {
                    if (lista[j] > lista[j + 1]) {
                        int temp = lista[j];
                        lista[j] = lista[j + 1];
                        lista[j + 1] = temp;
                        troca = true;
                    }
                }

            }
        } else {
            int n = lista.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (lista[j] < lista[j + 1]) {
                        int temp = lista[j];
                        lista[j] = lista[j + 1];
                        lista[j + 1] = temp;
                    }
                }
            }
        }

        return lista;
    }
    public  static int[] insertionSort(int[] lista,String flug){
        int key, j;
        for (int i = 0; i < lista.length; i++) {
            key = lista[i];
            j = i - 1;

            if(flug=="asc"){
                while (j >= 0 && lista[j] > key){
                    lista[j+1] = lista[j];
                    j--;
                }
            }else {
                while (j >= 0 && lista[j] < key){
                    lista[j+1] = lista[j];
                    j--;
                }
            }


            lista[j+1] = key;
        }
        return lista;
    }
    public  static int[] selectionSort(int[] lista, String flug){
        int min;
        for (int i = 0; i < lista.length; i++) {
            min = i;
            for (int j = i + 1 ; j < lista.length; j++) {
                if(flug == "asc"){
                    if(lista[min] > lista[j]){
                        min = j;
                    }
                } else {
                    if(lista[min] < lista[j]){
                        min = j;
                    }
                }

            }
            if( i != min ) {
                int temp = lista[i];
                lista[i] = lista[min];
                lista[min] = temp;
            }
        }
        return lista;
    }
    public static int[] quickSort(int[] arr, int low, int high, String flug) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high,flug);
            quickSort(arr, low, pivotIndex - 1,  flug);
            quickSort(arr, pivotIndex + 1, high,  flug);
        }
        return arr;
    }
    public static int partition(int[] arr, int low, int high,String flug) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if(flug =="asc"){
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            }else {
                if (arr[j] > pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }
}
