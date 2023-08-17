package trabalho1;

import java.util.Scanner;

public class Exercicios3 {
    public static void main(String[] args) {
        int impares=0;
        int[] arr = new int[10];
        Scanner pc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Digite um numero ");
            arr[i] = pc.nextInt();

            if(arr[i] % 2 !=0){
                System.out.println("IMPAR "+ arr[i]);
                impares = impares+   arr[i];
            }
        }
        System.out.println("SOMA de impares " + impares);
    }
}
