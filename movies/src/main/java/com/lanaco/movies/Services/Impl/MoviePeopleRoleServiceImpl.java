package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.MoviePeopleRole;
import com.lanaco.movies.Repository.MoviePeopleRoleRepository;
import com.lanaco.movies.Services.MoviePeopleRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoviePeopleRoleServiceImpl implements MoviePeopleRoleService {
    private final MoviePeopleRoleRepository moviePeopleRoleRepository;

    public MoviePeopleRoleServiceImpl(MoviePeopleRoleRepository moviePeopleRoleRepository){
        this.moviePeopleRoleRepository=moviePeopleRoleRepository;
    }
    @Override
    public MoviePeopleRole create(MoviePeopleRole moviePeopleRole){
        return moviePeopleRoleRepository.save(moviePeopleRole);
    }
    @Override
    public List<MoviePeopleRole>findAll(){
        return moviePeopleRoleRepository.findAllByMoviePeopleId(0);
    }
}
