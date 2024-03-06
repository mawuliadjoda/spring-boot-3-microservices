package com.adjoda.photoapp.api.users.service;

import com.adjoda.photoapp.api.users.shared.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    UserDTO createUser(UserDTO userDetails);
    UserDTO getUserDetailsByEmail(String email);
}
