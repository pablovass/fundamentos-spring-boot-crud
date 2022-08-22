package com.pablovass.fundamentos.controller;

import com.pablovass.fundamentos.caseuse.CreateUser;
import com.pablovass.fundamentos.caseuse.*;
import com.pablovass.fundamentos.entity.User;
import com.pablovass.fundamentos.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    // create get delete update
    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private  UserRepository userRepository;


    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser,UpdateUser updateUser,UserRepository userRepository) {
        this.createUser = createUser;
        this.getUser = getUser;
        this.deleteUser=deleteUser;
        this.updateUser=updateUser;
        this.userRepository=userRepository;
    }

    @GetMapping("/")
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody  User newUser) {
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    ResponseEntity<User>replaseUser(@RequestBody User newUser,@PathVariable Long id){
       return new ResponseEntity<>(updateUser.update(newUser, id),HttpStatus.OK);
    }
    // metodo relacionado con la paginacion
    @GetMapping("/pageable")
    List<User>getUserPageable(@RequestParam int page,@RequestParam int size){
        return  userRepository.findAll(PageRequest.of(page,size)).getContent();
    }
}