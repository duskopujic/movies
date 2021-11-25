package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role create(Role role);
    List<Role>findAll();
    Optional<Role>findOneById(int id);
    void deleteById(int id);
}
