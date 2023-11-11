import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import HasTable.HashTable;
import LinkedList.DoubleLinkedList;
import Relatorios.Curso;
import Relatorios.Disciplina;
import Relatorios.PlanoCurricular;

public class MOTOR {
  HashTable<Curso> HasCurso = new HashTable<Curso>(100);
  HashTable<Disciplina> HashDisciplinas = new HashTable<Disciplina>(100);
  private String message;

  private class TransformTopicos {
    public boolean temRepeticao;
    public ArrayList<String> topicos = new ArrayList<String>();

    public TransformTopicos(boolean tem, ArrayList<String> topicos) {
      this.temRepeticao = tem;
      this.topicos = topicos;
    }
  }

  public void start() {
    String inputFilePath = "/home/antoniositoe/Documentos/GitHub/Data-Structures-and-Algorithms/src/ficheiro.in";
    String outputFilePath = "ficheiro_saida.out";

    TextFile inputFile = new TextFile();
    inputFile.openToRead(inputFilePath);

    TextFile outputFile = new TextFile();
    outputFile.openToWrite(outputFilePath);

    while (inputFile.readyToRead()) {
      String linha = inputFile.readLine();
      // System.out.println(linha);

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

  public boolean CD(String linha, TextFile inputFile) {
    // So adicionamos disciplina a um curso previamente existente
    String[] linha2 = inputFile.readLine().split(" ");
    String[] partes = linha.split(" ");

    String top1 = inputFile.readLine().trim().toLowerCase();
    String top2 = inputFile.readLine().trim().toLowerCase();
    String top3 = inputFile.readLine().trim().toLowerCase();
    String top4 = inputFile.readLine().trim().toLowerCase();
    TransformTopicos obj = transformaTopicos(top1, top2, top3, top4);
    ArrayList<String> topicos = obj.topicos;

    int semestre = Integer.parseInt(partes[1]);
    int tipo = Integer.parseInt(partes[2]);
    String curso = partes[3].toLowerCase().trim();

    double numeroDeCreditos = Double.parseDouble(linha2[0]);
    String nomeDisciplina = linha2[1].toLowerCase().trim();

    var existeCurso = HasCurso.find(curso);
    if (existeCurso == null) {
      this.message = "Curso inexistente.";
      return false;
    }

    var disciplinaExiste = HashDisciplinas.find(nomeDisciplina);
    if (disciplinaExiste != null) {
      this.message = "Disciplina existente.";
      return false;
    }
    if (obj.temRepeticao) {
      this.message = "Sequencia de topicos com repeticoes.";
      return false;
    }

    Disciplina novDisciplina = new Disciplina(nomeDisciplina, numeroDeCreditos,
        topicos);

    try {
      HashDisciplinas.add(nomeDisciplina, novDisciplina);
    } catch (Exception e) {
      System.out.println("Erro ao adicionar disciplina");
    }
    // inserir a disciplina ao plano curricular
    PlanoCurricular planoCurricular = new PlanoCurricular(semestre, tipo == 1);
    planoCurricular.addDisciplinas(nomeDisciplina);

    // colocar o novo plano ao curso
    var cursoParaColocarPlano = existeCurso.getValue();
    cursoParaColocarPlano.addNovoPlanoCurricular(planoCurricular);

    return true;
  }

  public boolean RC(String linha) {
    String nome = pegaLinhaEretornaNome(linha);
    var cursoExistente = HasCurso.find(nome);

    if (cursoExistente == null) { // curso nao existe
      this.message = "Curso inexistente.";
      return false;
    }

    Curso cursoEmQuestao = cursoExistente.getValue();
    DoubleLinkedList planoCurricular = cursoEmQuestao.getPlanoCurricular();

    // System.out.println("O curso exite " + planoCurricular.toString());

    // curso existe

    return true;
  }

  public void CC(String linha) {
    String nome = pegaLinhaEretornaNome(linha);
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

  public void ID() {

  }

  public TransformTopicos transformaTopicos(String top1, String top2, String top3, String top4) {
    ArrayList<String> topicos = new ArrayList<String>();
    boolean temRepeticao = false;
    if (topicos.contains(top1)) {
      temRepeticao = true;
    }
    topicos.add(top1);

    if (topicos.contains(top2)) {
      temRepeticao = true;
    }
    topicos.add(top2);

    if (topicos.contains(top3)) {
      temRepeticao = true;
    }
    topicos.add(top3);

    if (topicos.contains(top4)) {
      temRepeticao = true;
    }
    topicos.add(top4);
    TransformTopicos topic = new TransformTopicos(temRepeticao, topicos);
    return topic;
  }

  public String pegaLinhaEretornaNome(String linha) {
    String[] inputString = linha.split(" ");
    return inputString[1].toLowerCase().trim();
  }

  public ArrayList<String> convertToLowerCase(List<String> inputList) {
    ArrayList<String> result = new ArrayList<>();
    for (String element : inputList) {
      result.add(element.toLowerCase());
    }
    return result;
  }
}
