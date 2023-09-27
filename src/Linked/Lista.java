package Linked;

public interface Lista {

  public boolean isEmpty();

  public void addFim(Object elemento);

  public void addPOS(int pos, Object elemento);

  public void mostrarPosicao(int pos);

  public Object remover();

  public int tamanhoLista();

  public void mostrarLinha();

  public int mostrarPosElemento(Object elemento);

  public void concatenarLista();  

}
