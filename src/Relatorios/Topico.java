package Relatorios;

import java.util.ArrayList;

public class Topico {
    private String nome;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Topico(String nome) {
        this.nome = nome;
    }
}
