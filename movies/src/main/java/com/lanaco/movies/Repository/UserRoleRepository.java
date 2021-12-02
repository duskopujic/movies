package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole>findAllByUsers_UserId(int Id);
    List<UserRole>findByUsers(Users users);
}
