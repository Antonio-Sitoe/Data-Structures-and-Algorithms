package LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class DoubleImplementation {
  public static void main(String[] args) {
    DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
    ArrayList<Integer> numerosAleatorios = generateRamdomNumbers();

    // Coloacando os numeros aleatorios dentro da lista 1000 numeros
    for (Integer numero : numerosAleatorios) {
      lista.insert(lista.end(), numero);
    }

    var mediaDePassos = generateReport(lista);
    System.out.println("Número médio de passos: " + mediaDePassos);
  }

  public static double generateReport(DoubleLinkedList<Integer> lista) {
    Random random = new Random();
    int numeroDeTentativas = 1000;
    int totalDePassos = 0;

    for (int i = 0; i < numeroDeTentativas; i++) {
      int numeroAleatorio = random.nextInt(1000) + 1;
      int passos = lista.findAndCountSteps(numeroAleatorio);
      if (passos != -1) {
        totalDePassos += passos;
      }
    }

    double mediaDePassos = (double) totalDePassos / numeroDeTentativas;
    System.out.println("Numeros de passos: " + totalDePassos);
    return mediaDePassos;
  }

  public static ArrayList generateRamdomNumbers() {
    Random random = new Random();
    ArrayList<Integer> numerosAleatorios = new ArrayList<>();
    int quantidadeNumeros = 1000;
    for (int i = 0; i < quantidadeNumeros; i++) {
      int numeroAleatorio = random.nextInt(100);
      numerosAleatorios.add(numeroAleatorio);
    }
    return numerosAleatorios;
  }
}
