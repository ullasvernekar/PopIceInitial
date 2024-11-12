package com.Project.ProductMapping.Repository;

import com.Project.ProductMapping.DTO.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
