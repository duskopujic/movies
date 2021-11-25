package com.lanaco.movies.Services;

import com.lanaco.movies.Models.ContentType;

import java.util.List;
import java.util.Optional;

public interface ContentTypeService {
    ContentType create(ContentType contentType);
    List<ContentType>findAll();
    Optional<ContentType> findOneById(int id);
    void deleteById(int id);
}
