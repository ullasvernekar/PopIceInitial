package com.Project.ProductMapping.Controller;

import com.Project.ProductMapping.DTO.Customer;
import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.DTO.User;
import com.Project.ProductMapping.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Customer")
public class Customercontroller  {

    @Autowired
    private CustomerServices customerServices;
    @PostMapping(value = "/saveUser")
    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
        return customerServices.saveCustomer(customer);
    }


    @GetMapping(value = "/findCustomerById/{id}")
    public ResponseEntity<ResponseStructure<Customer>> findCustomerById(@PathVariable long id) {
        return customerServices.findById(id);
    }

    @DeleteMapping(value = "/deleteCustomer")
    public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam long id) {
        return customerServices.deleteCustomer(id);
    }

    @GetMapping(value = "/findAllUser")
    public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
        return customerServices.findAllCustomer();
    }
}





