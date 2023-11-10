public class Testes {
  public static void main(String[] args) {
    TextFile outputFile = new TextFile();
    outputFile.openToWrite("testes.txt");
    outputFile.writeLine("dsdshdghsgd");
    outputFile.closeToWrite();
  }
}
