/*
7. Crie uma classe java de nome DesserializaJSON para ler / desserializar os objetos Serializados na Questão 6 e exibi-los.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DesserializaJSON {
    public static void main(String[] args) {
        try {
            // Lê os objetos serializados em JSON do arquivo "desenvolvedores.json"
            ObjectMapper objectMapper = new ObjectMapper();
            List<Desenvolvedor> desenvolvedores = objectMapper.readValue(
                new File("desenvolvedores.json"),
                new TypeReference<List<Desenvolvedor>>() {}
            );

            // Exibe os objetos desserializados
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                System.out.println("ID: " + desenvolvedor.getId());
                System.out.println("Nome: " + desenvolvedor.getNome());
                System.out.println("Username: " + desenvolvedor.getUsername());
                System.out.println("Email: " + desenvolvedor.getEmail());
                System.out.println("Habilidades Técnicas: " + desenvolvedor.getHabilidadesTecnicas());
                System.out.println("Região: " + desenvolvedor.getRegiao());
                System.out.println("Carga Horária Disponível: " + desenvolvedor.getCargaHorariaDisponivel());
                System.out.println("-----------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
