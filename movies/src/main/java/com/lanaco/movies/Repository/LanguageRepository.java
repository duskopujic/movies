package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    List<Language>findAllByLanguageIdGreaterThanOrderByLanguageIdDesc(int id);
}
