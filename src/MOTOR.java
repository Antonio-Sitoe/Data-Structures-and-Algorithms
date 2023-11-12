import java.util.ArrayList;
import java.util.List;

import HasTable.HashTable;
import Relatorios.Curso;
import Relatorios.Disciplina;
import Relatorios.PlanoCurricular;
import Relatorios.Topico;

// [] remocao de disciplina no plano curricular

public class MOTOR {
  HashTable<Curso> HasCurso = new HashTable<Curso>(100);
  HashTable<Disciplina> HashDisciplinas = new HashTable<Disciplina>(100);
  HashTable<Topico> HasTopicos = new HashTable<Topico>(100);

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
      } else if (linha.startsWith("ID")) {
        this.ID(linha, inputFile);
      } else if (linha.startsWith("RD")) {
        this.RD(linha, inputFile);
      } else if (linha.startsWith("PD")) {
        this.PD(linha, inputFile, outputFile);
      } else if (linha.startsWith("PP")) {
        this.PP(linha, outputFile);
      } else if (linha.startsWith("DT")) {
        this.DT(linha, outputFile);
      }

      outputFile.writeLine(this.message);
      this.message = "";
    }

    // Fechar os arquivos
    inputFile.closeToRead();
    outputFile.closeToWrite();
    System.out.println(HashDisciplinas.toString());
  }

  public boolean DT(String linha, TextFile outputFile) {
    String nomeTopico = this.pegaLinhaEretornaNome(linha);

    var existeTopico = HasTopicos.find(nomeTopico);
    if (existeTopico == null) {
      this.message = "Topico inexistente.";
      return false;
    }

    Topico topico = existeTopico.getValue();
    for (Disciplina disciplina : topico.getDisciplinas()) {
      outputFile.writeLine(disciplina.getNumeroDeCreditos() + " " + disciplina.getNome().toUpperCase());
    }

    return true;
  }

  public boolean PP(String linha, TextFile outputFile) {
    String curso = this.pegaLinhaEretornaNome(linha);

    var existeCurso = HasCurso.find(curso);
    if (existeCurso == null) {
      this.message = "Curso inexistente.";
      return false;
    }
    Curso cursoEmQuestao = existeCurso.getValue();
    var plano = cursoEmQuestao.getPlanoCurricular();

    if (plano.size() == 0) {
      this.message = "Disciplinas inexistentes.";
      return false;
    }

    for (PlanoCurricular pc : plano) {
      for (Disciplina disciplina : pc.getDisciplinas()) {
        String linhaToPrint = pc.getSemestre() + " " + (pc.isObrigatorio() == false ? 0 : 1)
            + " " + disciplina.getNumeroDeCreditos() + " " + disciplina.getNome().toUpperCase();
        outputFile.writeLine(linhaToPrint);
      }

    }
    return true;
  }

  public boolean PD(String linha, TextFile inputFile, TextFile outputFile) {
    String[] partes = linha.split(" ");
    String nomeDisciplina = partes[1].toLowerCase().trim();

    var disciplinaExiste = HashDisciplinas.find(nomeDisciplina);
    if (disciplinaExiste == null) {
      this.message = "Disciplina inexistente.";
      return false;
    }

    Disciplina dc = disciplinaExiste.getValue();

    for (String curso : dc.getCursos()) {
      var existeCurso = HasCurso.find(curso);
      if (existeCurso != null) {
        var planos = existeCurso.getValue().getPlanoCurricular();
        for (PlanoCurricular plano : planos) {

          for (Disciplina fd : plano.getDisciplinas()) {
            if (fd.getNome().equals(dc.getNome())) {
              String linhaToPrint = plano.getSemestre() + " " + (plano.isObrigatorio() == false ? 0 : 1) + " "
                  + existeCurso.getValue().getNome().toUpperCase();

              outputFile.writeLine(linhaToPrint);
            }
          }

        }
      }
    }
    outputFile.writeLine(Double.toString(dc.getNumeroDeCreditos()));
    for (String topico : dc.getTopicos()) {
      outputFile.writeLine(topico.toUpperCase());
    }

    return true;
  }

  public boolean RD(String linha, TextFile inputFile) {
    String[] partes = linha.split(" ");

    String curso = partes[1].toLowerCase().trim();
    String nomeDisciplina = inputFile.readLine().trim().toLowerCase();

    var existeCurso = HasCurso.find(curso);
    if (existeCurso == null) {
      this.message = "Curso inexistente.";
      return false;
    }

    var disciplinaExiste = HashDisciplinas.find(nomeDisciplina);
    if (disciplinaExiste == null) {
      this.message = "Disciplina inexistente.";
      return false;
    }

    Curso cursoEmQuestao = existeCurso.getValue();
    boolean disciplinaEstaNoPlano = cursoEmQuestao.pesquisarDisciplina(nomeDisciplina);

    if (disciplinaEstaNoPlano == false) {
      this.message = "Disciplina nao pertence ao plano curricular.";
      return false;
    }

    cursoEmQuestao.removeDisciplina(nomeDisciplina);
    this.message = "Remocao de disciplina com sucesso";
    return true;
  }

  public boolean ID(String linha, TextFile inputFile) {
    String[] partes = linha.split(" ");

    String nomeDisciplina = inputFile.readLine().trim().toLowerCase();
    int semestre = Integer.parseInt(partes[1]);
    int tipo = Integer.parseInt(partes[2]);
    String curso = partes[3].toLowerCase().trim();

    var existeCurso = HasCurso.find(curso);
    if (existeCurso == null) {
      this.message = "Curso inexistente.";
      return false;
    }

    var disciplinaExiste = HashDisciplinas.find(nomeDisciplina);
    if (disciplinaExiste == null) {
      this.message = "Disciplina inexistente.";
      return false;
    }

    Curso cursoEmQuestao = existeCurso.getValue();
    boolean disciplinaEstaNoPlano = cursoEmQuestao.pesquisarDisciplina(nomeDisciplina);

    if (disciplinaEstaNoPlano == true) {
      System.out.println("Disciplina pertence ao plano curricular.");
      this.message = "Disciplina pertence ao plano curricular.";
      return false;
    }

    PlanoCurricular planoCurricular = new PlanoCurricular(semestre, tipo == 1);
    planoCurricular.addDisciplinas(disciplinaExiste.getValue());
    disciplinaExiste.getValue().addCurso(curso);

    // colocar o novo plano ao curso
    var cursoParaColocarPlano = existeCurso.getValue();
    cursoParaColocarPlano.addNovoPlanoCurricular(planoCurricular);
    this.message = "Insercao de disciplina com sucesso.";
    return true;
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

    novDisciplina.addCurso(curso);
    // inserir a disciplina ao plano curricular
    PlanoCurricular planoCurricular = new PlanoCurricular(semestre, tipo == 1);
    planoCurricular.addDisciplinas(novDisciplina);

    // colocar o novo plano ao curso
    var cursoParaColocarPlano = existeCurso.getValue();
    cursoParaColocarPlano.addNovoPlanoCurricular(planoCurricular);

    for (String nome : topicos) {
      Topico topico = new Topico(nome);
      topico.addDisciplina(novDisciplina);
      try {
        HasTopicos.add(nome, topico);
      } catch (Exception e) {
        System.out.println("Erro ao addiconar topicos");
      }

    }

    return true;
  }

  public boolean RC(String linha) {
    String nome = pegaLinhaEretornaNome(linha);
    var cursoExistente = HasCurso.find(nome);

    if (cursoExistente == null) { // curso nao existe
      this.message = "Curso inexistente.";
      return false;
    }

    try {
      HasCurso.remove(nome);
    } catch (Exception e) {
      System.out.println("Falha ao remover curso");
    }

    this.message = "Remocao de curso com sucesso.";
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
