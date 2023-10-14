/*
1. Crie uma classe Java de entidade. Escolha uma entidade que você já propôs para seu Trabalho Prático. Exemplo: classe Filme (id, titulo, sinopse, diretor). A classe deve implementar a interface java.io.Serializable. Crie também uma classe que possua uma lista de objetos da entidade escolhida. Exemplo: classe Filmes, possuindo uma lista de Filme (List<Filme> filmes). Veja, nos slides sobre XML, os exemplos das classes Pessoa e Pessoas.
 */

import java.io.Serializable;
import java.util.List;

// Classe Entidade Desenvolvedor
public class Desenvolvedor implements Serializable {
    private int id;
    private String nome;
    private String username;
    private String email;
    private List<String> habilidadesTecnicas;
    private String regiao;
    private int cargaHorariaDisponivel;

    // Construtor
    public Desenvolvedor(int id, String nome, String username, String email,
            List<String> habilidadesTecnicas, String regiao, int cargaHorariaDisponivel) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.habilidadesTecnicas = habilidadesTecnicas;
        this.regiao = regiao;
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHabilidadesTecnicas() {
        return habilidadesTecnicas;
    }

    public void setHabilidadesTecnicas(List<String> habilidadesTecnicas) {
        this.habilidadesTecnicas = habilidadesTecnicas;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getCargaHorariaDisponivel() {
        return cargaHorariaDisponivel;
    }

    public void setCargaHorariaDisponivel(int cargaHorariaDisponivel) {
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }
}
