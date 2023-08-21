import java.io.*;

public class ListLines{
    public static void main(String[] args) {
        if (args.length != 1) {  // Verifica se o nome do arquivo foi passado como argumento
            System.out.println("Uso: java HeadCommand <arquivo.txt>");  // Caso não tenha sido, exibe uma mensagem de erro 
            return;
        }

        String filePath = args[0];  // Obtém o nome do arquivo a partir do argumento passado

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {  // Tenta abrir o arquivo
            String line;  // Variável para armazenar cada linha do arquivo
            int lineNumber = 1;  // Variável para armazenar o número da linha atual

            while ((line = reader.readLine()) != null && lineNumber <= 10) {  // Lê cada linha do arquivo até o final
                System.out.println(line);  // Exibe a linha atual
                lineNumber++;  // Incrementa o número da linha atual
            }
        } catch (IOException e) {  // Caso ocorra algum erro ao ler o arquivo
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());  
        }
    }
}
