import HasTable.HashTable;
import Relatorios.Curso;

public class MOTOR {
  HashTable<Curso> HasCurso;

  public void start() {
    String inputFilePath = "/home/antoniositoe/Documentos/GitHub/Data-Structures-and-Algorithms/src/ficheiro.in";
    String outputFilePath = "ficheiro_saida.txt";

    TextFile inputFile = new TextFile();
    inputFile.openToRead(inputFilePath);

    TextFile outputFile = new TextFile();
    outputFile.openToWrite(outputFilePath);

    while (inputFile.readyToRead()) {
      String linha = inputFile.readLine();

      if (linha.startsWith("CC")) {
        this.CC(linha);
        System.out.println("Comando CC Criar curso.");
      }

      // System.out.println(linha); // Imprimir no console (opcional)

      // Escrever a linha no arquivo de saída
      outputFile.writeLine(linha);
      outputFile.newLine();
    }

    // Fechar os arquivos
    inputFile.closeToRead();
    outputFile.closeToWrite();
  }

  public boolean CC(String linha) {
    String nome = linha.substring(0);
    Curso c = new Curso(nome);
    // add(nome, c);

    return true;
  }
}
