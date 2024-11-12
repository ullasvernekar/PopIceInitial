package com.Project.ProductMapping.Services;

import com.Project.ProductMapping.DAO.UserDao;
import com.Project.ProductMapping.DTO.ResponseStructure;
import com.Project.ProductMapping.DTO.User;
import com.Project.ProductMapping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class UserServices {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
        ResponseStructure<User> resoponseStructure = new ResponseStructure<>();
        User test = userDao.findUserByuId(user.getId());
        if (Objects.isNull(test)) {

            user = userDao.save(user);
            resoponseStructure.setStatus(HttpStatus.CREATED.value());
            resoponseStructure.setMessage("USER saved successfully");
            resoponseStructure.setData(user);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CREATED);
        } else {
            resoponseStructure.setStatus(HttpStatus.CONFLICT.value());
            resoponseStructure.setMessage("USER Not saved ");
            resoponseStructure.setData(null);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<ResponseStructure<User>> findUserById(long uId) {
        ResponseStructure<User> resoponseStructure = new ResponseStructure<>();
        User user = userDao.findUserByuId(uId);
        if (Objects.isNull(user)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("USER-ID Not Found ");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            User user1=userDao.findUserByuId(user.getUId());
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found USER by ID" + uId);
            resoponseStructure.setData(user);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<User>> deleteUser(long uId) {
        ResponseStructure<User> resoponseStructure = new ResponseStructure<>();
        User user = userDao.findUserByuId(uId );
        if (Objects.isNull(user)) {
            resoponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            resoponseStructure.setMessage("NO USER is Found");
            resoponseStructure.setData((null));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NOT_FOUND);
        } else {
            userDao.deleteUser(user);
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Deleted a USER");
            resoponseStructure.setData(user);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }


    public ResponseEntity<ResponseStructure<Page<User>>> findAll(Pageable pageable) {
        ResponseStructure<Page<User>> resoponseStructure = new ResponseStructure<>();
        Page<User> userPage = userRepository.findAll(pageable);
        if (userPage.isEmpty()) {
            resoponseStructure.setStatus(HttpStatus.NO_CONTENT.value());
            resoponseStructure.setMessage("NO USER Found");
            resoponseStructure.setData((userPage));
            return new ResponseEntity<>(resoponseStructure, HttpStatus.NO_CONTENT);
        } else {
            resoponseStructure.setStatus(HttpStatus.OK.value());
            resoponseStructure.setMessage("Found All USER");
            resoponseStructure.setData(userPage);
            return new ResponseEntity<>(resoponseStructure, HttpStatus.OK);
        }
    }


}
