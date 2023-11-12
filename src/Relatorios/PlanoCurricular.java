package Relatorios;

import java.util.ArrayList;

public class PlanoCurricular {
    private int semestre;
    private boolean obrigatorio;
    private ArrayList<Disciplina> disciplinas;

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplinas(Disciplina nomeDisciplina) {
        this.disciplinas.add(nomeDisciplina);
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public PlanoCurricular(int semestre, boolean obrigatorio) {
        this.semestre = semestre;
        this.obrigatorio = obrigatorio;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    @Override
    public String toString() {
        return "PlanoCurricular [semestre=" + semestre + ", obrigatorio=" + obrigatorio;
    }
}
