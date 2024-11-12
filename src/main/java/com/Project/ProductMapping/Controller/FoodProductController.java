package com.Project.ProductMapping.Controller;

import com.Project.ProductMapping.DTO.FoodProduct;
import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.Services.FoodProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/FoodProduct")
public class FoodProductController  {

    @Autowired
    private FoodProductServices foodProductServices;
    @PostMapping(value = "/saveFoodProduct/{id}")
    public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(@RequestBody FoodProduct foodProduct ,@PathVariable long id) {
        return foodProductServices.saveFoodProductr(foodProduct,id);
    }




    @GetMapping(value = "/findFoodProductById/{id}")
    public ResponseEntity<ResponseStructure<FoodProduct>> findFoodProductById(@PathVariable long id) {
        return foodProductServices.findFoodProductrById(id);
    }

    @DeleteMapping(value = "/deleteFoodProduct")
    public ResponseEntity<ResponseStructure<FoodProduct>> deleteFoodProduct(@RequestParam long id) {
        return foodProductServices.deleteFoodProduct(id);
    }

    @GetMapping(value = "/findAllFoodProduct")
    public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct() {
        return foodProductServices.findAllFoodProduct();
    }
}
