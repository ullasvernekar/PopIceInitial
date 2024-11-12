package com.Project.ProductMapping.Repository;

import com.Project.ProductMapping.DTO.FoodMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodMenuRepository extends JpaRepository<FoodMenu,Long> {
}
