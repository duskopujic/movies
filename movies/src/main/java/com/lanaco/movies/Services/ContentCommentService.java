package com.lanaco.movies.Services;

import com.lanaco.movies.Models.ContentComment;

import java.util.List;

public interface ContentCommentService {
    ContentComment create(ContentComment contentComment);
        List<ContentComment>findAll();
}
