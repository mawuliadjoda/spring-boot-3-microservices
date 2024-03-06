package com.adjoda.photoapp.api.users.ui.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LoginRequestModel {
    private String email;
    private String password;
}
