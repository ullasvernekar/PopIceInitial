package com.Project.ProductMapping.Services;

import com.Project.ProductMapping.DAO.FoodMenuDao;
import com.Project.ProductMapping.DAO.FoodproductDao;
import com.Project.ProductMapping.DTO.FoodMenu;
import com.Project.ProductMapping.DTO.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class FoodMenuServices {

    @Autowired
    private FoodMenuDao foodMenuDao;

    @Autowired
    private FoodproductDao foodproductDao;

    public ResponseEntity<ResponseStructure<FoodMenu>> saveFoodmenu(FoodMenu foodMenu,long id) {
        ResponseStructure<FoodMenu> resoponseStructure = new ResponseStructure<>();
        FoodMenu foodMenu1=foodMenuDao.findFoodmenuById(id);
        if (Objects.isNull(foodMenu1)) {

            FoodMenu foodMenu2 = foodMenuDao.save(foodMenu);
            resoponseStructure.setStatus(HttpStatus.CREATED.value());
            resoponseStructure.setMessage("USER saved successfully");
            resoponseStructure.setData(foodMenu);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
        } else {
            resoponseStructure.setStatus(HttpStatus.CONFLICT.value());
            resoponseStructure.setMessage("USER Not saved ");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<ResponseStructure<FoodMenu>> findFoodmenuById(long id) {
        ResponseStructure<FoodMenu> resoponseStructure = new ResponseStructure<>();
        FoodMenu foodmenu = foodMenuDao.findFoodmenuById(id);
        if (Objects.isNull(foodmenu)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("USER-ID Not Found ");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found USER by ID" + id);
            resoponseStructure.setData( foodmenu);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<FoodMenu>> deleteFoodmenu(long id) {
        ResponseStructure<FoodMenu> resoponseStructure = new ResponseStructure<>();
        FoodMenu foodmenu= foodMenuDao.findFoodmenuById(id);
        if (Objects.isNull(foodmenu)) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO USER is Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            foodMenuDao.deleteFoodmenu(foodmenu);
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Deleted a USER");
            resoponseStructure.setData(foodmenu);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }


    public ResponseEntity<ResponseStructure<List<FoodMenu>>> findAllFoodMenu() {
        ResponseStructure<List<FoodMenu>> resoponseStructure = new ResponseStructure<>();
        List<FoodMenu> foodmenu = foodMenuDao.findAllFoodmenu();
        if (foodmenu.isEmpty()) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO USER Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found All USER");
            resoponseStructure.setData(foodmenu);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }
}
