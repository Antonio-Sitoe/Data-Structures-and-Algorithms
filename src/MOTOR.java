import java.util.ArrayList;
import java.util.List;

import HasTable.HashTable;
import LinkedList.DoubleLinkedList;
import Relatorios.Curso;
import Relatorios.Disciplina;

public class MOTOR {
  HashTable<Curso> HasCurso = new HashTable<Curso>(100);
  HashTable<Disciplina> HashDisciplinas = new HashTable<Disciplina>(100);
  private String message;

  public void start() {
    String inputFilePath = "/home/antoniositoe/Documentos/GitHub/Data-Structures-and-Algorithms/src/ficheiro.in";
    String outputFilePath = "ficheiro_saida.out";

    TextFile inputFile = new TextFile();
    inputFile.openToRead(inputFilePath);

    TextFile outputFile = new TextFile();
    outputFile.openToWrite(outputFilePath);

    while (inputFile.readyToRead()) {
      String linha = inputFile.readLine();
      System.out.println(linha);

      if (linha.startsWith("CC")) {
        this.CC(linha);
      } else if (linha.startsWith("RC")) {
        this.RC(linha);
      } else if (linha.startsWith("CD")) {
        this.CD(linha, inputFile);
      }

      outputFile.writeLine(this.message);
      this.message = "";
    }

    // Fechar os arquivos
    inputFile.closeToRead();
    outputFile.closeToWrite();
    System.out.println(HasCurso.toString());
  }

  public void CD(String linha, TextFile inputFile) {
    ArrayList<String> blocos = this.processarBlocoCD(inputFile);
    String[] primeiraPosicao = blocos.get(0).split(" ");
    String[] partes = linha.split(" ");

    int semestre = Integer.parseInt(partes[1]);
    int tipo = Integer.parseInt(partes[2]);
    String curso = sanitizeName(partes[3]);
    String numeroDeCreditos = primeiraPosicao[0];
    String disciplina = primeiraPosicao[1];

    blocos.remove(0);
    ArrayList<String> topicos = blocos;

    System.out.println("Comando CD encontrado com informações adicionais:");
    for (String linhaAdicional : topicos) {
      System.out.println(linhaAdicional);
    }
    System.out.println();

    // verificar se existe

    // Disciplina novaDisciplina = new Disciplina();

    // System.out.println(blocos.toString());
  }

  public boolean RC(String linha) {
    String nome = sanitizeName(linha);
    var cursoExistente = HasCurso.find(nome);

    if (cursoExistente == null) { // curso nao existe
      this.message = "Curso inexistente.";
      return false;
    }

    Curso cursoEmQuestao = cursoExistente.getValue();
    DoubleLinkedList planoCurricular = cursoEmQuestao.getPlanoCurricular();

    System.out.println("O curso exite " + planoCurricular.toString());

    // curso existe

    return true;
  }

  public void CC(String linha) {
    String nome = sanitizeName(linha);
    Curso novoCurso = new Curso(nome);

    try {
      var existeCurso = HasCurso.find(nome);
      if (existeCurso == null) {
        HasCurso.add(nome, novoCurso);
        this.message = "Criacao de curso com sucesso.";
      } else {
        this.message = "Curso existente.";
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private ArrayList<String> processarBlocoCD(TextFile inputFile) {
    // Lê as linhas adicionais relacionadas ao comando CD
    List<String> linhasAdicionais = new ArrayList<>();
    while (inputFile.readyToRead()) {
      String linha = inputFile.readLine();
      // Verifica se a linha está relacionada ao bloco de informações do comando CD
      if (linha.trim().isEmpty()) {
        // Se a linha estiver vazia, termina o processamento do bloco CD
        break;
      }
      // Adiciona a linha à lista de linhas adicionais
      linhasAdicionais.add(linha);
    }

    return (ArrayList<String>) linhasAdicionais;
  }

  public String sanitizeName(String nome) {
    String inputString = nome;
    String processedString = inputString.replaceAll("\\s", "").toLowerCase();
    String result = processedString.substring(1);
    return result;
  }
}
