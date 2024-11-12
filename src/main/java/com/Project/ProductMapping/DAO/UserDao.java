package com.Project.ProductMapping.DAO;

import com.Project.ProductMapping.DTO.User;
import com.Project.ProductMapping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class UserDao {

    @Autowired
    public UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User findUserByuId(long uId) {
        Optional<User> optional = userRepository.findById(uId  );
        return optional.orElse(null);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }


}

