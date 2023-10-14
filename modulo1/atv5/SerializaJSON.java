/*
6. Crie uma classe Java de nome SerializaJSON para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando a Serialização de objetos da biblioteca Jackson. Ver também: Serialization and Deserialization in Java using Jackson A practical guide on how to serialize and deserialize objects to JSON in Java using Jackson.
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializaJSON {
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

        // Serializa os objetos em JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("desenvolvedores.json"), desenvolvedores);
            System.out.println("Objetos Desenvolvedor foram serializados em desenvolvedores.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

