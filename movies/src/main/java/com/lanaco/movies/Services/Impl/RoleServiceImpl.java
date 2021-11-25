package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Role;
import com.lanaco.movies.Repository.RoleRepository;
import com.lanaco.movies.Repository.UsersRepository;
import com.lanaco.movies.Services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    private RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    @Override
    public Role create(Role role){
        return roleRepository.save(role);
    }
    @Override
    public List<Role>findAll(){
        return roleRepository.findAllByRoleIdGreaterThanOrderByRoleIdDesc(0);
    }
    @Override
    public Optional<Role> findOneById(int id) {
        return roleRepository.findById(id);
    }
    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

}
