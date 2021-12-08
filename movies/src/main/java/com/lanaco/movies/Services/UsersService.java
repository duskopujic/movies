package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users create (Users users);
    List <Users>findAll();
    Optional<Users> findUsersByUsersName(String userName);
    boolean existByUsername(String username);
    boolean existByEmail(String email);
    Optional<Users> findByUserName(String userName);
    void deleteById(int id);
}
