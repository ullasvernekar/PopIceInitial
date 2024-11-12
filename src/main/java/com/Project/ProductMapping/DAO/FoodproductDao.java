package com.Project.ProductMapping.DAO;

import com.Project.ProductMapping.DTO.FoodProduct;
import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.Repository.FoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class FoodproductDao {
    @Autowired
    public FoodProductRepository foodProductRepository;

    public FoodProduct save(FoodProduct foodProduct) {
        return foodProductRepository.save(foodProduct);
    }


    public void deleteFoodProduct(FoodProduct foodProduct) {
       foodProductRepository.delete(foodProduct);
    }

    public FoodProduct findFoodProductById(long id) {
        Optional<FoodProduct> optional =foodProductRepository.findById(id);
        return optional.orElse(null);
    }

    public List<FoodProduct> findAllProduct() {
        return foodProductRepository.findAll();
    }
}

