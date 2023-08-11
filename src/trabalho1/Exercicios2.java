package trabalho1;

import java.util.Scanner;

public class Exercicios2 {
    public static void main(String[] args) {
        int pares=0,impares=0;
        int[] arr = new int[10];
       Scanner pc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Digite um numero ");
            arr[i] = pc.nextInt();

            if(arr[i] % 2 ==0){
                System.out.println("PAR "+ arr[i]);
                pares = pares + 1;
            }else {
                System.out.println("IMPAR "+ arr[i]);
                impares = impares + 1;
            }
        }
        System.out.println("Quantidades de pares " + pares);
        System.out.println("Quantidades de impares " + impares);
    }
}
