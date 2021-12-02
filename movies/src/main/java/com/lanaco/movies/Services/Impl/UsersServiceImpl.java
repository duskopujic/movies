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
        return usersRepository.findAllByUserIdGreaterThanOrderByUserIdDesc(0);
    }

    @Override
    public Optional<Users> findUsersByUsersName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    @Override
    public Optional<Users> findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }
    public Users save(UserDto userDto) throws RegistrationException {
    if(!usersRepository.existsByEmail(userDto.getEmail())
        && !usersRepository.existsByUserName(userDto.getUserName())){
        Users users=usersRepository.save(buildUserFromDto(userDto));
        userDto.getRoleIds().forEach(roleId->{
            UserRoleId key = new UserRoleId(users.getUserId(), roleId);
            Role role = roleRepository.getById(roleId);
            userRoleRepository.save(new UserRole(key,users,role) );
        });
        return usersRepository.save(users);
    }
    throw new RegistrationException("E-mail i username moraju biti jedinstveni!");
    }


    private Users buildUserFromDto(UserDto userDto){
        Users users = new Users();
        if (userDto.getUserId()!=null)
            users.setUserId(userDto.getUserId());
            users.setUserName(userDto.getUserName());
            users.setFirstName(userDto.getFirstName());
            users.setLastName(userDto.getLastName());
            users.setPhoneNumber(userDto.getPhoneNumber());
            users.setAdress(userDto.getAdress());
            users.setEmail(userDto.getEmail());
            users.setPassword(userDto.getPassword());
            return users;
    }
}
