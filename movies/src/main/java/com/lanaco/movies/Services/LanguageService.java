package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageService {
    Language create (Language language);
        List<Language>findAll();
    Optional<Language> findOneById(int id);
    void deleteById(int id);
}
