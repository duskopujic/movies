package com.lanaco.movies.Services;

import com.lanaco.movies.Models.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole create(UserRole userRole);
    List<UserRole>findAll();
}
