import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileReader;

public class LerArquivo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);

            String nomeArquivo = properties.getProperty("arquivo");
            int linhaInicial = Integer.parseInt(properties.getProperty("linha_inicial"));
            int linhaFinal = Integer.parseInt(properties.getProperty("linha_final"));

            try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
                String linha;
                int linhaAtual = 1;
                while ((linha = reader.readLine()) != null) {
                    if (linhaAtual >= linhaInicial && linhaAtual <= linhaFinal) {
                        System.out.println(linha);
                    }
                    linhaAtual++;
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de propriedades: " + e.getMessage());
        }
    }
}
