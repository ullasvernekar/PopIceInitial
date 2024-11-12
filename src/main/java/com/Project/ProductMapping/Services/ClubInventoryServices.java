package com.Project.ProductMapping.Services;

import com.Project.ProductMapping.DAO.ClubInventoryDao;
import com.Project.ProductMapping.DAO.ProductDao;
import com.Project.ProductMapping.DTO.ClubInventory;
import com.Project.ProductMapping.DTO.ClubInventory;
import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class ClubInventoryServices {

    @Autowired
    private ClubInventoryDao clubInventoryDao;

    @Autowired
    private ProductDao productDao;

    public ResponseEntity<ResponseStructure<ClubInventory>> saveClubinventory(ClubInventory clubinventory, long id) {
        ResponseStructure<ClubInventory> resoponseStructure = new ResponseStructure<>();
        Product product=productDao.findProductById(id);
        if (Objects.isNull(product)) {
             resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("USER Not saved successfully");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            clubinventory.setProduct(product);
            clubinventory.setType(product.getConversion() * clubinventory.getQuantity());
            resoponseStructure.setStatus(HttpStatus.CREATED.value());
            resoponseStructure.setMessage("ClubInventory saved for the product ");
            resoponseStructure.setData(clubInventoryDao.save(clubinventory));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<ResponseStructure<ClubInventory>> findClubInventoryById(long id) {
        ResponseStructure<ClubInventory> resoponseStructure = new ResponseStructure<>();
        ClubInventory clubInventory=clubInventoryDao.findClubinventoryId(id);
        if (Objects.isNull(clubInventory)){
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("USER-ID Not Found ");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found USER by ID" + id);
            resoponseStructure.setData(clubInventory);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<ClubInventory>> deleteClubInventory(long id) {
        ResponseStructure<ClubInventory> resoponseStructure = new ResponseStructure<>();
        ClubInventory clubInventory=clubInventoryDao.findClubinventoryId(id);
        if (Objects.isNull(clubInventory)) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO USER is Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
           clubInventoryDao.deleteClubInventory(clubInventory.getProduct().getClubInventory());
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Deleted a USER");
            resoponseStructure.setData(clubInventory);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }


    public ResponseEntity<ResponseStructure<List<ClubInventory>>> findAllClubInventory() {
        ResponseStructure<List<ClubInventory>> resoponseStructure = new ResponseStructure<>();
        List<ClubInventory> clubInventories=clubInventoryDao.findAllClubinventory();
        if (clubInventories.isEmpty()) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO USER Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found All USER");
            resoponseStructure.setData(clubInventories);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }
}
