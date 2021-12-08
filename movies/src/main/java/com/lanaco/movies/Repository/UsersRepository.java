package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Users;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{

    Optional<Users>findByUserName(String userName);
    Optional<Users>findByEmail(String email);

    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
}




