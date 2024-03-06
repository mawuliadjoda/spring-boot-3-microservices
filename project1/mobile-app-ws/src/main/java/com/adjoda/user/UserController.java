package com.adjoda.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    /*
    @GetMapping
    public String getUser() {
        return "get users was called";
    }

     */
    @GetMapping(path = "/{id}")
    public UserRest getUserById(@PathVariable String id) {
        UserRest userRest = UserRest.builder()
                .firstName("Mawuli")
                .lastName("ADJODA")
                .email("koffimawuli.adjoda@gmail.com")
                .build();
        return userRest;
    }

    @GetMapping
    public String getUsers(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users was called";
    }
    @PostMapping
    public ResponseEntity<UserRest> createUser(@Validated @RequestBody UserDetailsRequest userDetailsRequest) {
        String firstName = null;

       if(true) throw new UserServiceException("A userServiceException is thrown");


        UserRest userRest = UserRest.builder()
                .firstName("test")
                .lastName("test")
                .email("test@test.com")
                .build();
        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
