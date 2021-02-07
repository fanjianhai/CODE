package com.xiaofan.repository;

import com.xiaofan.domain.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {

}

