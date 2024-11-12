package com.Project.ProductMapping.Controller;

import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController(value = "/Product")

public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping(value = "/saveProduct")
    public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
        return productServices.saveProduct(product);
    }


//    @GetMapping(value = "/findProductById/{id}")
//    public ResponseEntity<ResponseStructure<Product>> findProductById(@PathVariable long id) {
//        return productServices.findProductById(id);
//    }

    @DeleteMapping(value = "/deleteProduct")
    public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam long id) {
        return productServices.deleteProduct(id);
    }

    @GetMapping(value = "/findAllProduct")
    public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
        return productServices.findAllProduct();
    }
}

