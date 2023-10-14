/*
1. Crie uma classe Java de entidade. Escolha uma entidade que você já propôs para seu Trabalho Prático. Exemplo: classe Filme (id, titulo, sinopse, diretor). A classe deve implementar a interface java.io.Serializable. Crie também uma classe que possua uma lista de objetos da entidade escolhida. Exemplo: classe Filmes, possuindo uma lista de Filme (List<Filme> filmes). Veja, nos slides sobre XML, os exemplos das classes Pessoa e Pessoas.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Desenvolvedores implements Serializable {
    private List<Desenvolvedor> desenvolvedores;

    // Construtor
    public Desenvolvedores() {
        this.desenvolvedores = new ArrayList<>();
    }

    // Adicionar um Desenvolvedor à lista
    public void adicionarDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedores.add(desenvolvedor);
    }

    // Remover um Desenvolvedor da lista
    public void removerDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedores.remove(desenvolvedor);
    }

    // Outros métodos de manipulação da lista
    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
    

}