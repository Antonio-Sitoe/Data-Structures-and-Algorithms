package Relatorios;

public class PlanoCurricular {
    private int semestre;
    private boolean obrigatorio;

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

    }
}
