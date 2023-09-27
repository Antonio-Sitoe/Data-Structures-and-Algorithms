package Linked;

public class Node {
  private Object objecto;
  private Node proximo;

  public Node(Object novoObject) {
    this.objecto = novoObject;
    this.proximo = null;
  }

  public Node(Object objecto, Node proximo) {
    this.objecto = objecto;
    this.proximo = proximo;
  }

  public Object getObjecto() {
    return objecto;
  }

  public void setObjecto(Object objecto) {
    this.objecto = objecto;
  }

  public Node getProximo() {
    return proximo;
  }

  public void setProximo(Node proximo) {
    this.proximo = proximo;
  }

}
