package com.Project.ProductMapping.Services;

import com.Project.ProductMapping.DAO.CustomerDao;
import com.Project.ProductMapping.DTO.Customer;
import com.Project.ProductMapping.DTO.Product;
import com.Project.ProductMapping.DTO.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class CustomerServices {

    @Autowired
    private CustomerDao customerDao;

    public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
        ResponseStructure<Customer> resoponseStructure = new ResponseStructure<>();
        Customer customer1 = customerDao.findCustomerById(customer.getId());
        if (Objects.isNull(customer1)) {
            customer1 =customerDao.saveCustomer(customer);
            resoponseStructure.setStatus(HttpStatus.CREATED.value());
            resoponseStructure.setMessage("USER saved successfully");
            resoponseStructure.setData(customer);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
        } else {
            resoponseStructure.setStatus(HttpStatus.CONFLICT.value());
            resoponseStructure.setMessage("USER Not saved ");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<ResponseStructure<Customer>> findById(long id) {
        ResponseStructure<Customer> resoponseStructure = new ResponseStructure<>();
        Customer customer = customerDao.findCustomerById(id);
        if (Objects.isNull(customer)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("USER-ID Not Found ");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found USER by ID" + id);
            resoponseStructure.setData(customer);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<Customer>>deleteCustomer(long id ) {
        ResponseStructure<Customer> resoponseStructure = new ResponseStructure<>();
        Customer customer = customerDao.findCustomerById(id);
        if (Objects.isNull(customer)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("NO USER is Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            customerDao.deleteCustomer(customer);
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Deleted a Customer");
            resoponseStructure.setData(customer);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }


    public ResponseEntity<ResponseStructure<List<Customer>>> findAllCustomer() {
        ResponseStructure<List<Customer>> resoponseStructure = new ResponseStructure<>();
        List<Customer>customers =customerDao.findAllCustomer();
        if (customers.isEmpty()) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO Customer Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found All USER");
            resoponseStructure.setData(customers);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

 }


