package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Exception.RegistrationException;
import com.lanaco.movies.Models.CompositeKeys.UserRoleId;
import com.lanaco.movies.Models.Dto.UserDto;
import com.lanaco.movies.Models.Role;
import com.lanaco.movies.Models.UserRole;
import com.lanaco.movies.Repository.RoleRepository;
import com.lanaco.movies.Repository.UserRoleRepository;
import com.lanaco.movies.Repository.UsersRepository;
import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.MBeanRegistrationException;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder enc;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${server.port}")
    private int serverPort;

    public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public Users create(Users users){
        return usersRepository.save(users);
    }
    @Override
    public List<Users>findAll(){
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findUsersByUsersName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    @Override
    public boolean existByUsername(String userName) {
        return false;
    }

    @Override
    public boolean existByEmail(String email) {
        return false;
    }

    @Override
    public Optional<Users> findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    @Override
    public void deleteById(int id) {
        usersRepository.deleteById(id);
    }
}
