package com.adjoda.photoapp.api.users.ui.service;

import com.adjoda.photoapp.api.users.ui.entity.UserEntity;
import com.adjoda.photoapp.api.users.ui.repository.UsersRepository;
import com.adjoda.photoapp.api.users.ui.shared.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    @Override
    public UserDTO createUser(UserDTO userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword("test");

        usersRepository.save(userEntity);

        UserDTO returnValue = modelMapper.map(userEntity, UserDTO.class);

        return returnValue;
    }
}
