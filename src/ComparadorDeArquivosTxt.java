import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ComparadorDeArquivosTxt {

    public static void main(String[] args) {
        String arquivo1 = "/home/antoniositoe/Documentos/GitHub/Data-Structures-and-Algorithms/src/ficheiro.txt";
        String arquivo2 = "/home/antoniositoe/Documentos/GitHub/Data-Structures-and-Algorithms/src/ficheiro_saida.txt";

        if (compararConteudo(arquivo1, arquivo2)) {
            System.out.println("Os arquivos são iguais.");
        } else {
            System.out.println("Os arquivos são diferentes.");
        }
    }

    public static boolean compararConteudo(String caminhoArquivo1, String caminhoArquivo2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(caminhoArquivo1));
             BufferedReader reader2 = new BufferedReader(new FileReader(caminhoArquivo2))) {

            String linhaArquivo1;
            String linhaArquivo2;

            while ((linhaArquivo1 = reader1.readLine()) != null && (linhaArquivo2 = reader2.readLine()) != null) {
                if (!linhaArquivo1.equals(linhaArquivo2)) {
                    return false; // As linhas são diferentes
                }
            }

            // Se chegou até aqui, os arquivos são iguais até o momento
            // Verificar se ambos os arquivos têm o mesmo número de linhas
            return reader1.readLine() == null && reader2.readLine() == null;

        } catch (IOException e) {
            e.printStackTrace();
            return false; // Ocorreu um erro na leitura dos arquivos
        }
    }
}
