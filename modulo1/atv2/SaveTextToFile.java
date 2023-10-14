import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveTextToFile {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();  // Lista para armazenar as linhas de texto
        
        Scanner scanner = new Scanner(System.in);   
        
        System.out.println("Digite as linhas de texto (digite 'FIM' para encerrar):");
        
        while (true) {  
            String line = scanner.nextLine();  
            if (line.equals("FIM")) {
                break;
            }
            lines.add(line);
        }
        
        System.out.print("Digite o nome do arquivo para salvar as linhas: ");
        String fileName = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Linhas salvas no arquivo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
        
        scanner.close();
    }
}
