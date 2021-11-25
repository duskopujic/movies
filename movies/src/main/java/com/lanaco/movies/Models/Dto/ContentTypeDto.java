package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.ContentType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContentTypeDto {

    public int contentTypeId;
    public String name;

    public ContentType toContentType(){
        return new ContentType()
                .setName(name);
    }


}
