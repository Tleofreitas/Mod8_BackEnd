package com.devsuperiorT.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Mapeamento do JPA
@Entity
@Table (name = "tb_user") // Nome da tabela no banco de dados
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // Id auto incrementável
    private Long id;
    private String name;
    @Column(unique = true) // Não recebe e-mails duplicados
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;

    // Relacionamento UM para MUITOS com Order
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, LocalDate brithDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = brithDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBrithDate() {
        return birthDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.birthDate = brithDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
