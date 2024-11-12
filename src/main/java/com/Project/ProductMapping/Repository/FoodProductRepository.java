package com.Project.ProductMapping.Repository;

import com.Project.ProductMapping.DTO.FoodProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodProductRepository extends JpaRepository<FoodProduct,Long> {
}
