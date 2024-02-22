package com.adjoda.photoapp.api.users.service;

import com.adjoda.photoapp.api.users.shared.UserDTO;

public interface UsersService {
    UserDTO createUser(UserDTO userDetails);
}
