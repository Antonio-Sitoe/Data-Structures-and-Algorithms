package Relatorios;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private double numeroDeCreditos;
    private ArrayList<String> topicos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNumeroDeCreditos() {
        return numeroDeCreditos;
    }

    public void setNumeroDeCreditos(double numeroDeCreditos) {
        this.numeroDeCreditos = numeroDeCreditos;
    }

    public ArrayList<String> getTopicos() {
        return topicos;
    }

    public void setTopicos(ArrayList<String> topicos) {
        this.topicos = topicos;
    }

    public Disciplina(String nome, double numeroDeCreditos) {
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.topicos = new ArrayList<String>();
    }

}
