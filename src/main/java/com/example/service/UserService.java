package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.dto.UserRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUSer(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());

        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getOneUser(int id) throws UserNotFoundException {

        User user = repository.findUserById(id);
        if (user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not Found with id : " + id);
        }
    }

}
