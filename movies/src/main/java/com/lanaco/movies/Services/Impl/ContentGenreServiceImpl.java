package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.ContentGenre;
import com.lanaco.movies.Repository.ContentGenreRepository;
import com.lanaco.movies.Services.ContentGenreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentGenreServiceImpl implements ContentGenreService {
    private final ContentGenreRepository contentGenreRepository;

    public ContentGenreServiceImpl(ContentGenreRepository contentGenreRepository){
        this.contentGenreRepository=contentGenreRepository;
    }
    @Override
    public ContentGenre create(ContentGenre contentGenre){
        return contentGenreRepository.save(contentGenre);
    }
    @Override
    public List<ContentGenre>findAll(){
        return contentGenreRepository.findAllByContentId(0);
    }
}
