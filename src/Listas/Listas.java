package Listas;

public class Listas {
  private Elemento primeiro;
  private Elemento ultimo;
  private int tamanho;

    public Listas() {
      this.tamanho = 0;
    /*  cada elemento sabe apenas quem e o seu proximo
     *  Isso faz com que podemos fazer operacoes rapidamente
     *  Ela tem um tamanho dinamico
     *  A lista ligada -> nao tem acesso directo ou aleatorio
     *  Queremos adicionar muitos elementos.
     */
   
  }

  public void adicionar(String novoValor){
    Elemento novoElemento  = new Elemento(novoValor);

  }

  public void remover(String novoValor){

  }

  public Elemento get(int posicao){
    return null;
  }

  public Elemento getPrimeiro() {
    return primeiro;
  }


  public void setPrimeiro(Elemento primeiro) {
    this.primeiro = primeiro;
  }


  public Elemento getUltimo() {
    return ultimo;
  }


  public void setUltimo(Elemento ultimo) {
    this.ultimo = ultimo;
  }


  public int getTamanho() {
    return tamanho;
  }


  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }


  

}
