package com.adjoda.photoapp.api.users.ui.controller;

import com.adjoda.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.adjoda.photoapp.api.users.ui.model.CreateUserResponseModel;
import com.adjoda.photoapp.api.users.service.UsersService;
import com.adjoda.photoapp.api.users.shared.UserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;

    private final Environment environment;

    @GetMapping("/status/check")
    public String status() {
        return "working on port: " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody @Valid CreateUserRequestModel createUserRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDTO userDTO = modelMapper.map(createUserRequestModel, UserDTO.class);
        UserDTO createUser = usersService.createUser(userDTO);

        CreateUserResponseModel returnValue = modelMapper.map(createUser, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
