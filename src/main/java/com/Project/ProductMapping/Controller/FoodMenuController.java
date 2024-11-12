package com.Project.ProductMapping.Controller;

import com.Project.ProductMapping.DTO.FoodMenu;
import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.Services.FoodMenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/FoodMenu")
public class FoodMenuController     {

    @Autowired
    private FoodMenuServices foodmenueServices;
    @PostMapping(value = "/saveFoodmenu")
    public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodmenu(@RequestBody FoodMenu foodmenu,long id) {
        return foodmenueServices.saveFoodmenu(foodmenu,id);
    }


    @GetMapping(value = "/findFoodmenuById/{id}")
    public ResponseEntity<ResponseStructure<FoodMenu>> findFoodmenuById(@PathVariable long id) {
        return foodmenueServices.findFoodmenuById(id);
    }

    @DeleteMapping(value = "/deleteFoodmenue")
    public ResponseEntity<ResponseStructure<FoodMenu>> deleteFoodmenu(@RequestParam long id) {
        return foodmenueServices.deleteFoodmenu(id);
    }

    @GetMapping(value = "/findAllFoodmenu")
    public ResponseEntity<ResponseStructure<List<FoodMenu>>> findAllFoodmenu() {
        return foodmenueServices.findAllFoodMenu();
    }
}
