package com.picpaybackend.picpaybackend.Controller;

import com.picpaybackend.picpaybackend.Entities.User;
import com.picpaybackend.picpaybackend.Services.UserService;
import com.picpaybackend.picpaybackend.dtos.User.UserCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> creteUser(UserCreateDTO dados){
        User newUser = userService.createUser(dados);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
