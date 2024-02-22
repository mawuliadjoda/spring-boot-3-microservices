package com.adjoda.photoapp.api.users.repository;

import com.adjoda.photoapp.api.users.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
