package com.Project.ProductMapping.Services;

import com.Project.ProductMapping.DAO.ClubInventoryDao;
import com.Project.ProductMapping.DAO.FoodproductDao;
import com.Project.ProductMapping.DAO.ProductDao;
import com.Project.ProductMapping.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FoodProductServices {

    @Autowired
    private FoodproductDao foodproductDao;

    @Autowired
    private ProductDao productDao;


    public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProductr(FoodProduct foodProduct, long id) {
        ResponseStructure<FoodProduct> resoponseStructure = new ResponseStructure<>();
        Product product = productDao.findProductById(id);
        if (Objects.isNull(product)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("Product Not saved ");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            foodProduct.setProduct(product);
            foodProduct.setProductPrice(product.getPrice() * foodProduct.getQuantity());
            resoponseStructure.setStatus(HttpStatus.CREATED.value());
            resoponseStructure.setMessage("Product saved successfully");
            resoponseStructure.setData(foodproductDao.save(foodProduct));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
        }
    }
    public ResponseEntity<ResponseStructure<FoodProduct>> findFoodProductrById ( long id){
            ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<>();
            FoodProduct foodProduct = foodproductDao.findFoodProductById(id);
            if (Objects.isNull(foodProduct)) {
                responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
                responseStructure.setMessage("USER-ID Not Found ");
                responseStructure.setData((null));
                return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
            } else {
                responseStructure.setStatus(HttpStatus.OK.value());
                responseStructure.setMessage("Found USER by ID" + id);
                responseStructure.setData(foodProduct);
                return new ResponseEntity<>(responseStructure, HttpStatus.OK);
            }
        }


        public ResponseEntity<ResponseStructure<FoodProduct>> deleteFoodProduct ( long id){
            ResponseStructure<FoodProduct> resoponseStructure = new ResponseStructure<>();
            FoodProduct foodProduct = foodproductDao.findFoodProductById(id);
            if (Objects.isNull(foodProduct)) {
                resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
                resoponseStructure.setMessage("NO USER is Found");
                resoponseStructure.setData((null));
                return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
            } else {
                foodproductDao.deleteFoodProduct(foodProduct);
                resoponseStructure.setStatus(HttpStatus.OK.value());
                resoponseStructure.setMessage("Deleted a USER");
                resoponseStructure.setData(foodProduct);
                return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
            }
        }


        public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct () {
            ResponseStructure<List<FoodProduct>> resoponseStructure = new ResponseStructure<>();
            List<FoodProduct> foodProducts = foodproductDao.findAllProduct();
            if (foodProducts.isEmpty()) {
                resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
                resoponseStructure.setMessage("NO USER Found");
                resoponseStructure.setData((null));
                return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
            } else {
                resoponseStructure.setStatus(HttpStatus.OK.value());
                resoponseStructure.setMessage("Found All USER");
                resoponseStructure.setData(foodProducts);
                return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
            }
        }
    }

