package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.Language;
import com.lanaco.movies.Repository.LanguageRepository;
import com.lanaco.movies.Services.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository){
        this.languageRepository=languageRepository;
    }
    @Override
    public Language create(Language language){
        return languageRepository.save(language);
    }
    @Override
    public List<Language>findAll(){
        return languageRepository.findAllByLanguageIdGreaterThanOrderByLanguageIdDesc(0);
    }
    @Override
    public Optional<Language> findOneById(int id){
        return languageRepository.findById(id);
    }
    @Override
    public void deleteById(int id){
        languageRepository.deleteById(id);
    }
}
