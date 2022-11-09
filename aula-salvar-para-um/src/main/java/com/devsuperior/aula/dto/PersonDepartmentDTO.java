package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Person;

// Classe de Pessoa aninhada com o Departamneto
public class PersonDepartmentDTO {

    private Long id;
    private String name;
    private Double salary;
    // Departamento (Não pode aninhar DTO com Entidade, por isso criou DepartmentDTO)
    private DepartmentDTO department;

    public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Recebe entidade e copia para o DTO
    public PersonDepartmentDTO(Person entity) {
        id = entity.getId();
        name = entity.getName();
        salary = entity.getSalary();
        department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }
}
