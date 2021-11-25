package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role>findAllByRoleIdGreaterThanOrderByRoleIdDesc(int id);
}
