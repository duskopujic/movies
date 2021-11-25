package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Genre;
import com.lanaco.movies.Repository.GenreRepository;
import com.lanaco.movies.Services.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    private GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
        @Override
        public Genre create(Genre genre){
        return genreRepository.save(genre);
        }
        @Override
        public List<Genre>findAll(){
        return genreRepository.findAllByGenreIdGreaterThanOrderByGenreIdDesc(0);
            }
        @Override
    public Optional<Genre> findOneById(int id){
        return genreRepository.findById(id);
        }
        @Override
    public void deleteById(int id){
        genreRepository.deleteById(id);
        }


}
