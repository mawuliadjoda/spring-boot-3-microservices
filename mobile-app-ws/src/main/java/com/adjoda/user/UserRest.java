package com.adjoda.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRest {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
