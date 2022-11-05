package com.devsuperiorD2.sisEvento.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_atividade") // Nome da tabela no banco de dados
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto incrementável
    private Integer id;
    private String nome;
    @Column(columnDefinition = "TEXT") // Para poder receber texto longo
    private String descricao;
    private Double preco;

    // Relacionamento MUITOS para UM com Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id") // Chave estrangeira do banco
    private Categoria categoria;

    // Relacionamento UM para MUITOS com Bloco
    @OneToMany(mappedBy = "atividade")
    private List<Bloco> blocos = new ArrayList<>();

    @ManyToMany(mappedBy = "atividades")
    /* Em MUITOS para MUITOS, não pode repetir o par, portanto
     *  usa-se Set e Hash Set ao invés de List*/
    private Set<Participante> participantes = new HashSet<>();

    public Atividade() {
    }

    public Atividade(Integer id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
