package com.Project.ProductMapping.Controller;

import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.DTO.User;
import com.Project.ProductMapping.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping
@RestController(value = "/User")
public class UserController {

    @Autowired
    public UserServices userServices;

    @PostMapping(value = "/saveUser")
    public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
        return userServices.saveUser(user);
    }


    @GetMapping(value = "/findUserById/{uId}")
    public ResponseEntity<ResponseStructure<User>> findUserById(@RequestParam long uId) {
        return userServices.findUserById(uId);
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam long id) {
        return userServices.deleteUser(id);
    }

    @GetMapping(value = "/findAllUsers")
    public ResponseEntity<ResponseStructure<Page<User>>> findAllUser(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size)
         /*   @RequestParam(defaultValue = "id") String sort) */{
        PageRequest pageable;
        pageable = PageRequest.of(page,size);
        return userServices.findAll(pageable);

    }
}


