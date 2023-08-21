package algoritmos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] lista = {6,70, 8,64,15,32,54,12,67};

        int min;
        for (int i = 0; i < lista.length; i++) {
            min =i;
            for (int j = i+1; j <  lista.length; j++) {
                if(lista[j] < lista[min]){
                    min = j;
                }
            }
            if(min != i) {
                int temp = lista[i];
                lista[i] = lista[min];
                lista[min] = temp;
            }
        }
        System.out.println(Arrays.toString(lista));
    }
}
