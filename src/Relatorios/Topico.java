package Relatorios;

public class Topico {
    private String nome;
    private Topico proximo;
    private Topico anterior;

    public Topico(String nome) {
        this.nome = nome;
        this.proximo = null;
        this.anterior = null;
    }

    // Métodos getters, setters e outras operações relevantes
}

