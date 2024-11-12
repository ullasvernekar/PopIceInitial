package com.Project.ProductMapping.Services;

import com.Project.ProductMapping.DAO.ProductDao;
import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class ProductServices {
    @Autowired
    private ProductDao productDao;




    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
        ResponseStructure<Product> resoponseStructure = new ResponseStructure<>();
        product.setTotal(product.getConversion() * product.getPrice());
        resoponseStructure.setStatus(HttpStatus.CREATED.value());
        resoponseStructure.setMessage("Product saved successfully");
        resoponseStructure.setData(productDao.saveProduct(product));
        return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
    }


    public ResponseEntity<ResponseStructure<Product>> deleteProduct(long id) {
        ResponseStructure<Product> resoponseStructure = new ResponseStructure<>();
        Product product = productDao.findProductById(id);
        if (Objects.isNull(product)) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO Product is Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
           productDao.deleteProduct(product);
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Deleted a Product");
            resoponseStructure.setData(product);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }


    public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
        ResponseStructure<List<Product>> resoponseStructure = new ResponseStructure<>();
        List<Product> products = productDao.findAllProduct();
        if (products.isEmpty()) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO Product Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found All Product");
            resoponseStructure.setData(products);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }
}
