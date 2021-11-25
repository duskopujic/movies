package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Repository.UsersRepository;
import com.lanaco.movies.Models.Users;
import com.lanaco.movies.Services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

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
}
