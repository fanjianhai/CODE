package com.xiaofan.repository;

import com.xiaofan.domain.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepositoryCrudRepository extends CrudRepository<Users,Integer> {
}

