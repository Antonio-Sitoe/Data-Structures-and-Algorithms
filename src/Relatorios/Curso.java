package Relatorios;

import LinkedList.DoubleLinkedList;

public class Curso {
  private String nome;
  private DoubleLinkedList<PlanoCurricular> planoCurricular;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public DoubleLinkedList<PlanoCurricular> getPlanoCurricular() {
    return planoCurricular;
  }

  public void addNovoPlanoCurricular(PlanoCurricular planoCurricular) {
    this.planoCurricular.insert(this.planoCurricular.end(), planoCurricular);
  }

  public void setPlanoCurricular(DoubleLinkedList<PlanoCurricular> planoCurricular) {
    this.planoCurricular = planoCurricular;
  }

  public Curso(String nome) {
    this.nome = nome;
    this.planoCurricular = new DoubleLinkedList<PlanoCurricular>();
  }

}
