package com.lanaco.movies.Services;

import com.lanaco.movies.Models.Season;

import javax.xml.ws.Service;
import java.util.List;

public interface SeasonService {
    Season create(Season season);
    List<Season>findAll();
}
