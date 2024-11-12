package com.Project.ProductMapping.Controller;

import com.Project.ProductMapping.DTO.ClubInventory;
import com.Project.ProductMapping.DTO.ClubInventory;
import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.Services.ClubInventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Clubinventory")
public class ClubInventoryController {

    @Autowired
    private ClubInventoryServices clubInventoryServices;


    @PostMapping(value = "/saveClubinventory/{id}")
    public ResponseEntity<ResponseStructure<ClubInventory>> saveClubinventory(@RequestBody ClubInventory clubinventory, @PathVariable long id) {
        return clubInventoryServices.saveClubinventory(clubinventory,id);
    }


    @GetMapping(value = "/findClubinventoryById/{id}")
    public ResponseEntity<ResponseStructure<ClubInventory>> findClubinventoryById(@PathVariable long id) {
        return clubInventoryServices.findClubInventoryById(id);
    }

    @DeleteMapping(value = "/deleteClubinventory/{id}")
    public ResponseEntity<ResponseStructure<ClubInventory>> deleteClubinventory(@PathVariable long id) {
        return clubInventoryServices.deleteClubInventory(id);
    }

    @GetMapping(value = "/findAllClubinventory")
    public ResponseEntity<ResponseStructure<List<ClubInventory>>> findAllClubinventory() {
        return clubInventoryServices.findAllClubInventory();
    }
}
