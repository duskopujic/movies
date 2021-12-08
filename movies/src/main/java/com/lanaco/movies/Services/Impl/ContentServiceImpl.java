package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Repository.ContentRepository;
import com.lanaco.movies.Services.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;
    public ContentServiceImpl(ContentRepository contentRepository)
    {
        this.contentRepository=contentRepository;
    }
    @Override
    public Content create(Content content)
    {
        return contentRepository.save(content);
    }
    @Override
    public List<Content>findAll()
    {
        return contentRepository.findAll();
    }
    @Override
    public Optional<Content> findOneById(int id)
    {
        return contentRepository.findById(id);
    }

    @Override
    public List<Content> findAllByOrderByRating() {
        return contentRepository.findAllByOrderByRating();
    }

    @Override
    public void deleteById(int id) {
        contentRepository.deleteById(id);

    }

    @Override
    public List<Double> findAllRating() {
        return contentRepository.findAllRating();
    }

    @Override
    public List<Content> findAllByOrderByReleaseDate() {
        return contentRepository.findAllByOrderByReleaseDate();
    }

}
