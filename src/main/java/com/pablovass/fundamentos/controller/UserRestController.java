package com.pablovass.fundamentos.controller;

import com.pablovass.fundamentos.caseuse.CreateUser;
import com.pablovass.fundamentos.caseuse.GetUser;
import com.pablovass.fundamentos.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    // create get delete update
    private GetUser getUser;
    private CreateUser createUser;


    public UserRestController(GetUser getUser, CreateUser createUser) {
        this.createUser = createUser;
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody  User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }
}