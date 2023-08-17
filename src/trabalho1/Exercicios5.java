package trabalho1;

import java.util.Scanner;

public class Exercicios5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        int[] arr = new int[30];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Digite um numero ");
            numero = sc.nextInt();
            if(i > 0){
                System.out.println("AQui " + (arr[i - 1] > numero));
                while (arr[i - 1] >= numero ){
                    System.out.println("Por favor insira um numero maiores ");
                    numero = sc.nextInt();
                }
            }
            arr[i] = numero;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("NUMERO " + arr[i]);
        }
    }
}
