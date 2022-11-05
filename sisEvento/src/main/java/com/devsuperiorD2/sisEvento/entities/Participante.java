package com.devsuperiorD2.sisEvento.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_participante") // Nome da tabela no banco de dados
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id auto incrementável
    private Integer id;
    private String nome;
    @Column(unique = true) // Não recebe e-mails duplicados
    private String email;

    // Relacionamento MUITOS para MUITOS com Atividade
    @ManyToMany
    @JoinTable(name = "tb_participante_atividade",
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    /* Em MUITOS para MUITOS, não pode repetir o par, portanto
     *  usa-se Set e Hash Set ao invés de List*/
    private Set<Atividade> atividades = new HashSet<>();

    public Participante() {
    }

    public Participante(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }
}
