package com.bchennu.demo.controllers;

import com.bchennu.demo.model.User;
import com.bchennu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value="/", produces = "application/json")
    public ResponseEntity<List<User>> findAllUsers(){

        List<User> users=(List<User>)userService.findAll();
       /* if (users.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<User> findbById(@PathVariable("id") Long id){

       //use this service - validationService.isValid(id);
        User user=userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping(value="/create",headers="Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
        System.out.println("Creating User "+user.getName());
        //TODO userService.createUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}", headers ="Accept=application/json")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        //TODO userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/update", headers="Accept=application/json")
    public ResponseEntity<Void> updateUser(@RequestBody User currentUser)
    {
        User user = userService.findById(currentUser.getId());
        if (user==null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        user.setId(currentUser.getId());
        user.setName(currentUser.getName());
        //TODO userService.update(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
