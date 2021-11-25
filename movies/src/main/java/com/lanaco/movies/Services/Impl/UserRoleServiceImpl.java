package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Repository.UserRoleRepository;
import com.lanaco.movies.Repository.UsersRepository;
import com.lanaco.movies.Services.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository){
        this.userRoleRepository=userRoleRepository;
    }
    @Override
    public UserRole create(UserRole userRole){
        return userRoleRepository.save(userRole);
    }
    @Override
    public List<UserRole>findAll(){
        return userRoleRepository.findAllByUserId(0);
    }
}
