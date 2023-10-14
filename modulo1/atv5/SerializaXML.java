/*
4. Crie uma classe Java de nome SerializaXML para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando a Serialização de objetos da biblioteca Jackson. Ver também: XML Serialization and Deserialization with Jackson | Baeldung.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializaXML {
    public static void main(String[] args) {
        // Cria uma lista para armazenar objetos Desenvolvedor
        List<Desenvolvedor> desenvolvedores = new ArrayList<>();

        // Instancia alguns objetos Desenvolvedor
        Desenvolvedor desenvolvedor1 = new Desenvolvedor(1, "João", "joao123", "joao@example.com",
                List.of("Java", "Spring", "JavaScript"), "São Paulo", 40);
        Desenvolvedor desenvolvedor2 = new Desenvolvedor(2, "Maria", "maria456", "maria@example.com",
                List.of("Python", "Django", "React"), "Rio de Janeiro", 35);

        // Adiciona os objetos à lista
        desenvolvedores.add(desenvolvedor1);
        desenvolvedores.add(desenvolvedor2);

        // Serializa os objetos em XML
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("desenvolvedores.xml"), desenvolvedores);
            System.out.println("Objetos Desenvolvedor foram serializados em desenvolvedores.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
