package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Users;

import java.util.List;

public interface UsersService {
    Users create (Users users);
    List <Users>findAll();

}
