package com.Project.ProductMapping.Repository;

import com.Project.ProductMapping.DTO.Customer;
import com.Project.ProductMapping.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

 public User findByuId(long uId);
}
