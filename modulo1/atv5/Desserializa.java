/*
3. Crie uma classe java de nome DesserializaJava para ler / desserializar os objetos Serializados na Questão 2 e exibi-los. 
 */

import java.io.*;
import java.util.List;

public class Desserializa {
    public static void main(String[] args) {
        // Lê os objetos serializados do arquivo "desenvolvedores.ser"
        try {
            FileInputStream fileIn = new FileInputStream("desenvolvedores.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            // Faz a desserialização da lista de Desenvolvedores
            List<Desenvolvedor> desenvolvedores = (List<Desenvolvedor>) in.readObject();
            
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
            
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


