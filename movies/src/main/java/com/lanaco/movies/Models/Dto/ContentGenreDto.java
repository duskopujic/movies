package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.ContentGenre;
import lombok.Data;

@Data
public class ContentGenreDto {

    private int contentId;
    private int genreId;

    public ContentGenre toContentGenre(){
        return new ContentGenre()
                .setContentId(contentId)
                .setGenreId(genreId);
    }
}

