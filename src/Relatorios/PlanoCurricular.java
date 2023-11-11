package Relatorios;

import java.util.ArrayList;

public class PlanoCurricular {
    private int semestre;
    private boolean obrigatorio;
    private ArrayList<String> disciplinas;

    public ArrayList<String> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplinas(String nomeDisciplina) {
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
        this.disciplinas = new ArrayList<String>();
    }
}
