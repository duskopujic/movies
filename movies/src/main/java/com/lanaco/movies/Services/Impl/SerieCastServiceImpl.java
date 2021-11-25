package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.SerieCast;
import com.lanaco.movies.Repository.SerieCastRepository;
import com.lanaco.movies.Services.SerieCastService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SerieCastServiceImpl implements SerieCastService {
    private final SerieCastRepository serieCastRepository;

    public SerieCastServiceImpl(SerieCastRepository serieCastRepository){
        this.serieCastRepository = serieCastRepository;
    }
    @Override
    public SerieCast create(SerieCast serieCast){
        return serieCastRepository.save(serieCast);
    }
    @Override
    public List<SerieCast>findAll(){
        return serieCastRepository.findAllByMoviePeopleId(0);
    }
}
