package Relatorios;

public class PlanoCurricular {
    private int semestre;
    private boolean obrigatorio;
    private PlanoCurricular proximo;
    private PlanoCurricular anterior;

    public PlanoCurricular(int semestre, boolean obrigatorio) {
        this.semestre = semestre;
        this.obrigatorio = obrigatorio;
        this.proximo = null;
        this.anterior = null;
    }
    // Métodos getters, setters e outras operações relevantes
}

