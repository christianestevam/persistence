/*
5. Crie uma classe java de nome DesserializaXML para ler / desserializar os objetos Serializados na Questão 4 e exibi-los.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DesserializaXML {
    public static void main(String[] args) {
        try {
            // Lê os objetos serializados em XML do arquivo "desenvolvedores.xml"
            ObjectMapper xmlMapper = new XmlMapper();
            List<Desenvolvedor> desenvolvedores = xmlMapper.readValue(new File("desenvolvedores.xml"),
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, Desenvolvedor.class));

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
