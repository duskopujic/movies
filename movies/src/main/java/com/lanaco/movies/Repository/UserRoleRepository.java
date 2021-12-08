package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
@Transactional
@Modifying
    List<UserRole>findByUsers(Users users);
}
