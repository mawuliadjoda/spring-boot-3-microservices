package com.adjoda.photoapp.api.users.ui.repository;

import com.adjoda.photoapp.api.users.ui.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
}
