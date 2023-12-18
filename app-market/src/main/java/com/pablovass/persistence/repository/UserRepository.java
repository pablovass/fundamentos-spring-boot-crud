package com.pablovass.persistence.repository;

import com.pablovass.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity ,String> {
}
