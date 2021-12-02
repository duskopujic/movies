package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Users create (Users users);
    List <Users>findAll();
    Optional<Users> findUsersByUsersName(String userName);
    Optional<Users> findByUserName(String userName);
}
