package com.adjoda.photoapp.api.users.ui.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CreateUserRequestModel {

    @NotNull(message = "Fist name cannot be null")
    @Size(min = 2, message = "Fist name must not be less than two character")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name must not be less than two character")
    private String lastName;

    @NotNull(message = "Last cannot be null")
    @Email
    private String email;

    @NotNull(message = "password name cannot be null")
    @Size(min = 8, max = 16 ,message = "password must be equal or greater than 8 characters and less than 16 characters")
    private String password;
}
