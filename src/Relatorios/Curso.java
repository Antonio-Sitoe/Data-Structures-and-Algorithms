package Relatorios;

import java.util.ArrayList;

public class Curso {
  private String nome;
  private ArrayList<PlanoCurricular> planoCurricular;

  public ArrayList<PlanoCurricular> getPlanoCurricular() {
    return planoCurricular;
  }

  public void setPlanoCurricular(ArrayList<PlanoCurricular> planoCurricular) {
    this.planoCurricular = planoCurricular;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void addNovoPlanoCurricular(PlanoCurricular planoCurricular) {
    this.planoCurricular.add(planoCurricular);
  }

  public boolean pesquisarDisciplina(String nome) {
    for (PlanoCurricular plano : this.planoCurricular) {
      for (Disciplina disciplina : plano.getDisciplinas()) {
        if (disciplina.getNome().equals(nome)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean removeDisciplina(String nome) {
    for (int i = 0; i < this.planoCurricular.size(); i++) {
      PlanoCurricular plano = this.planoCurricular.get(i);
      for (int j = 0; j < plano.getDisciplinas().size(); j++) {
        Disciplina disciplina = plano.getDisciplinas().get(j);
        if (disciplina.getNome().equals(nome)) {
          this.planoCurricular.remove(i);
        }
      }
    }

    return true;
  }

  public Curso(String nome) {
    this.nome = nome;
    this.planoCurricular = new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Curso [nome=" + nome + ", planoCurricular=" + planoCurricular + "]";
  }

}
