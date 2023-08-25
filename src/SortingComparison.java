import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortingComparison {


    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                trocas++;
            }
        }

        System.out.println("SelectionSort comparacoes: " + comparacoes);
        System.out.println("SelectionSort trocas: " + trocas);
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int comparacoes = 0;
        int trocas = 0;

        for (int j = low; j < high; j++) {
            comparacoes++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                trocas++;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        trocas++;

        System.out.println("QuickSort comparacoes: " + comparacoes);
        System.out.println("QuickSort trocas: " + trocas);

        return i + 1;
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocas++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        System.out.println("BubbleSort comparacoes: " + comparacoes);
        System.out.println("BubbleSort trocas: " + trocas);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            comparacoes++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                trocas++;
                comparacoes++;
            }
            arr[j + 1] = key;
        }

        System.out.println("InsertionSort comparacoes: " + comparacoes);
        System.out.println("InsertionSort Swaps: " + trocas);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arraySizes = { 500, 5000, 50000 };

        try (FileWriter writer = new FileWriter("out.txt")) {
            for (int size : arraySizes) {
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = random.nextInt(100000) + 1;
                }

                writer.write("\nTamanho do Array: " + size + "\n");
                System.out.println("Tamanho do Array   " + size);

                int[] copy = arr.clone();
                writer.write("\nSelectionSort:\n");
                long startTime = System.currentTimeMillis();
                selectionSort(copy);
                long endTime = System.currentTimeMillis();
                writer.write("Tempo : " + (endTime - startTime) + " ms\n");

                copy = arr.clone();
                writer.write("\nQuickSort:\n");
                startTime = System.currentTimeMillis();
                quickSort(copy, 0, copy.length - 1);
                endTime = System.currentTimeMillis();
                writer.write("Tempo: " + (endTime - startTime) + " ms\n");
//
//                copy = arr.clone();
//                writer.write("\nBubbleSort:\n");
//                startTime = System.currentTimeMillis();
//                bubbleSort(copy);
//                endTime = System.currentTimeMillis();
//                writer.write("Tempo: " + (endTime - startTime) + " ms\n");
//
//                copy = arr.clone();
//                writer.write("\nInsertionSort:\n");
//                startTime = System.currentTimeMillis();
//                insertionSort(copy);
//                endTime = System.currentTimeMillis();
//                writer.write("Tempo: " + (endTime - startTime) + " ms\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

