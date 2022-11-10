package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired // Recurso para trazer nome da Category
	private CategoryRepository categoryRepository;
	
	public ProductDTO insert (ProductDTO dto) {
		
		// Criar Product
		Product entity = new Product();

		// Copiar dto para Product
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		
		// Percorrer a lista e criar entidades categorias
		for (CategoryDTO catDto : dto.getCategories()) {
			
			// Category cat = new Category();
			// cat.setId(catDto.getId());
			
			// Recurso para trazer nome da Category
			Category cat = categoryRepository.getReferenceById(catDto.getId());
			entity.getCategories().add(cat);
		}
		
		// Salvar
		entity = repository.save(entity);
		
		// Retornar
		return new ProductDTO(entity);
	}

}
