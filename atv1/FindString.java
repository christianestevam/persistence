import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindString {
    public static void main(String[] args) {
        if (args.length != 2) {  // Verifica se o nome do arquivo foi passado como argumento
            System.out.println("Uso: java FindString <caminho_do_arquivo> <substring>");
            return;
        }

        String filePath = args[0];  
        String substringToSearch = args[1];  

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {  // Tenta abrir o arquivo
            String line;  // Variável para armazenar cada linha do arquivo
            while ((line = reader.readLine()) != null) {  // Lê cada linha do arquivo até o final
                if (line.contains(substringToSearch)) {  // Verifica se a linha atual contém a substring
                    System.out.println(line);  // Exibe a linha atual
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
