package Relatorios;

import LinkedList.DoubleLinkedList;

public class Curso<T> {
  private String nome;
  private DoubleLinkedList<T> planoCurricular;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public DoubleLinkedList<T> getPlanoCurricular() {
    return planoCurricular;
  }

  public void setPlanoCurricular(DoubleLinkedList<T> planoCurricular) {
    this.planoCurricular = planoCurricular;
  }

  public Curso(String nome) {
    this.nome = nome;
    this.planoCurricular = new DoubleLinkedList<>();
  }

}
