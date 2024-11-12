package com.Project.ProductMapping.Repository;

import com.Project.ProductMapping.DTO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public Customer findByContact(long contact);
}
