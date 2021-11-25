package com.lanaco.movies.Services;

import com.lanaco.movies.Models.SerieCast;

import java.util.List;

public interface SerieCastService {
    SerieCast create(SerieCast serieCast);
    List<SerieCast>findAll();
}
