package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.MovieRole;
import com.lanaco.movies.Repository.MovieRoleRepository;
import com.lanaco.movies.Services.MovieRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieRoleServiceImpl implements MovieRoleService {
    private final MovieRoleRepository movieRoleRepository;

    private MovieRoleServiceImpl(MovieRoleRepository movieRoleRepository){
        this.movieRoleRepository=movieRoleRepository;
    }
    @Override
    public MovieRole create(MovieRole movieRole){
        return movieRoleRepository.save(movieRole);
    }
    @Override
    public List<MovieRole>findAll(){
        return movieRoleRepository.findAll();
    }
    @Override
    public Optional<MovieRole>findOneById(int id){
        return movieRoleRepository.findById(id);
    }
    @Override
    public void deleteById(int id){
        movieRoleRepository.deleteById(id);
    }
}
