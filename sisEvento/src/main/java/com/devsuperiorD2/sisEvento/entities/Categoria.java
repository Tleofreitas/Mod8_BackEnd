package com.devsuperiorD2.sisEvento.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;

import java.util.ArrayList;
import java.util.List;

// Mapeamento do JPA
@Entity
@Table(name = "tb_categoria") // Nome da tabela no banco de dados
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto incrementável
    private Integer id;
    @Column(columnDefinition = "TEXT") // Para poder receber texto longo
    private String descricao;

    // Relacionamento UM para MUITOS com Atividade
    @OneToMany(mappedBy = "categoria")
    private List<Atividade> atividade = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atividade> getAtividade() {
        return atividade;
    }
}
