package com.Project.ProductMapping.DAO;

import com.Project.ProductMapping.DTO.FoodMenu;
import com.Project.ProductMapping.Repository.FoodMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class FoodMenuDao {

    @Autowired
    public FoodMenuRepository foodMenuRepository;

    public FoodMenu save(FoodMenu foodmenu) {
        return foodMenuRepository.save(foodmenu);
    }


    public void deleteFoodmenu(FoodMenu foodmenu) {
       foodMenuRepository.delete(foodmenu);
    }

    public FoodMenu findFoodmenuById(long id) {
        Optional<FoodMenu> optional =foodMenuRepository.findById(id);
        return optional.orElse(null);
    }

    public List<FoodMenu> findAllFoodmenu() {
        return foodMenuRepository.findAll();
    }
}

