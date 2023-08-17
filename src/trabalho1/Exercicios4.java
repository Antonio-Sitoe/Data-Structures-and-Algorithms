package trabalho1;

import java.util.Scanner;

public class Exercicios4 {
    public static void main(String[] args) {
//        10 quartos para alugar de 0 a 9
//        armazenar nome e email
//        inicia cm 10 quartos vazios
//        fazer um loop para adicionar os quartos
//        informar o nome e email
//        informar onde ele vai ser inserido em termos de indice
        int n = 0;
        int index=0;
        String nome; String email;
        Docente[] docentes = new Docente[10];

        Scanner sc = new Scanner(System.in);
        System.out.println(
                docentes.length
        );
//
        System.out.print("Quantos quartos serao alugados ");
        n = sc.nextInt();

        if(n < docentes.length ){
            for (int i = 0; i <= n; i++) {
                System.out.println("Digite o email ");
                email =sc.next();

                System.out.println("Digite o nome ");
                nome = sc.next();

                System.out.println("Quarto ");
                index = sc.nextInt();

                if(index < docentes.length){
                    Docente novo = new Docente(nome, email);
                    docentes[index] = novo;
                }else {
                    break;
                }
            }
            System.out.println("Quartos ocupados ");
            for (int i = 0; i < docentes.length; i++) {
                if(docentes[i] != null){
                    System.out.println(i+1+ " "+ docentes[i].nome + ", " + docentes[i].email);
                }
            }
         } else {
            System.out.print("Deve apenas escolher abaixo de 10");
        }
    }
}
