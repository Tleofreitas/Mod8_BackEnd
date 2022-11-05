package com.devsuperiorT.dscommerce.repositories;

import com.devsuperiorT.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
