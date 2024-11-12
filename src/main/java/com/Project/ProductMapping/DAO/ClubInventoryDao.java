package com.Project.ProductMapping.DAO;

import com.Project.ProductMapping.DTO.ClubInventory;
import com.Project.ProductMapping.DTO.ClubInventory;
import com.Project.ProductMapping.Repository.ClubInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClubInventoryDao {

    @Autowired
    public ClubInventoryRepository clubInventoryRepository;

    public ClubInventory save(ClubInventory clubinventory) {
        return clubInventoryRepository.save(clubinventory);
    }


    public void deleteClubInventory(ClubInventory clubinventory) {
       clubInventoryRepository.delete(clubinventory);
    }

    public ClubInventory findClubinventoryId(long id) {
        Optional<ClubInventory> optional =clubInventoryRepository.findById(id);
        return optional.orElse(null);
    }

    public List<ClubInventory> findAllClubinventory() {
        return clubInventoryRepository.findAll();
    }
}

