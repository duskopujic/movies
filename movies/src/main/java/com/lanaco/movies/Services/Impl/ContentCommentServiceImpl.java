package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.ContentComment;
import com.lanaco.movies.Repository.ContentCommentRepository;
import com.lanaco.movies.Services.ContentCommentService;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCommentServiceImpl implements ContentCommentService {
    private final ContentCommentRepository contentCommentRepository;

    public ContentCommentServiceImpl(ContentCommentRepository contentCommentRepository){
        this.contentCommentRepository=contentCommentRepository;
    }
    @Override
    public ContentComment create(ContentComment contentComment){
        return contentCommentRepository.save(contentComment);
    }
    @Override
    public List<ContentComment>findAll(){
        return contentCommentRepository.findAllByCommentId(0);
    }
}
