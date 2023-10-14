/*
2. Crie uma classe Java de nome SerializaJava para instanciar objetos da classe definida na Questão 1 e adicionar esses objetos em uma Lista. Depois percorrer a lista e Serializar os objetos em disco/ssd. Serialize usando a Serialização de objetos da própria API Java. Ver também: Introduction to Java Serialization | Baeldung.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializa {
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

        // Serializa os objetos em disco
        try {
            FileOutputStream fileOut = new FileOutputStream("desenvolvedores.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(desenvolvedores);
            out.close();
            fileOut.close();
            System.out.println("Objetos Desenvolvedor foram serializados em desenvolvedores.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Agora você pode ler os objetos de volta a partir do arquivo "desenvolvedores.ser"
    }
}
