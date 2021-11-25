package com.lanaco.movies.Services.Impl;

import com.lanaco.movies.Models.ContentType;
import com.lanaco.movies.Repository.ContentTypeRepository;
import com.lanaco.movies.Services.ContentTypeService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentTypeServiceImpl implements ContentTypeService {
   private final ContentTypeRepository contentTypeRepository;

   public ContentTypeServiceImpl(ContentTypeRepository contentTypeRepository){
       this.contentTypeRepository=contentTypeRepository;
   }
   @Override
    public ContentType create(ContentType contentType) {
       return contentTypeRepository.save(contentType);
   }

   @Override
    public List<ContentType>findAll(){
       return contentTypeRepository.findAll();
   }

   @Override
   public Optional<ContentType> findOneById(int id) {
       Optional<ContentType>  result = contentTypeRepository.findById(id);
       return result;
   }

    @Override
    public void deleteById(int id) {
        contentTypeRepository.deleteById(id);
    }


}
