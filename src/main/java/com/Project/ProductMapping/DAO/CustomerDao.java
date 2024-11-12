package com.Project.ProductMapping.DAO;

import com.Project.ProductMapping.DTO.Customer;
import com.Project.ProductMapping.DTO.FoodProduct;
import com.Project.ProductMapping.DTO.User;
import com.Project.ProductMapping.Repository.CustomerRepository;
import com.Project.ProductMapping.Repository.FoodProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CustomerDao {

    @Autowired
    public CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public Customer findCustomerById(long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}








