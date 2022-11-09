package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Inserir Objeto aninhado no banco OPÇÃO 1 --------------------------------------------------------------------------------
//    {
//        "name": "Nova Pessoa",
//        "salary": 8000.0,
//        "department": {
//            "id": 1
//        }
//    }
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {

    	// Criar entidade Person
        Person entity = new Person();
        
        // Copiar atributos do dto para a entidade
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        // Criar entidade Department e pegar o ID e o nome do departamento
        Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());

        // Criar entidade Department e pegar somente o ID
        // Department dept = new Department();
        // dept.setId(dto.getDepartment().getId()); 

        // Associar Department com Person
        entity.setDepartment(dept);

        // Salvar no Banco de Dados
        entity = repository.save(entity);

        // Retornar entidade atualizada em DTO
        return new PersonDepartmentDTO(entity);
    }


    // Inserir Objeto aninhado no banco OPÇÃO 2 --------------------------------------------------------------------------------
//    {
//        "name": "Nova Pessoa",
//        "salary": 8000.0,
//        "departmentId": 1
//    }
    public PersonDTO insert(PersonDTO dto) {

    	// Criar entidade Person
        Person entity = new Person();
        
        // Copiar atributos do dto para a entidade
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //Department dept = departmentRepository.getReferenceById(dto.getDepartmentId());

        // Criar Department e setar ID
        Department dept = new Department();
        dept.setId(dto.getDepartmentId());

        // Associar Department com Person
        entity.setDepartment(dept);

        // Salvar no Banco de Dados
        entity = repository.save(entity);

        // Retornar entidade atualizada em DTO
        return new PersonDTO(entity);
    }

}
