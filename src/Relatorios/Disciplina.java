package Relatorios;
import LinkedList.DoubleLinkedList;

public class Disciplina {
    private String nome;
    private double numeroDeCreditos;
    private DoubleLinkedList<String> topicos;

    public Disciplina(String nome, double numeroDeCreditos) {
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.topicos = new DoubleLinkedList<>();
    }

    // Métodos getters, setters e outras operações relevantes
}
