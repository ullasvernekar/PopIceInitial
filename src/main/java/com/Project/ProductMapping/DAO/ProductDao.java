package com.Project.ProductMapping.DAO;

import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.User;
import com.Project.ProductMapping.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDao {

    @Autowired
    public ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public Product findProductById(long id) {
        Optional<Product> optional =productRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}

