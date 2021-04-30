package com.dani.monkeyd.app.appingen.controllers;

import com.dani.monkeyd.app.appingen.models.Users;
import com.dani.monkeyd.app.appingen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> users=userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/User/{email}")
    public ResponseEntity<Users> getUser(@PathVariable("email") String email){
        Users users=userService.getUser(email);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/auth/{email}")
    public ResponseEntity<String> authUsers(@PathVariable("email") String email){
        String mdp=userService.authUser(email);
        return new ResponseEntity<>(mdp, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users users){
        Users users1=userService.addUsers(users);
        return new ResponseEntity<>(users1, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUsers(@RequestBody Users users){
        Users users1=userService.updateUsers(users);
        return new ResponseEntity<>(users1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteUsers(@PathVariable("email") String email){
        userService.deleteUsersByEmail(email);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}

