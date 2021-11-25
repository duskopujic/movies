package com.lanaco.movies.Models.Dto;

import com.lanaco.movies.Models.Content;
import com.lanaco.movies.Models.ContentComment;
import com.lanaco.movies.Models.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContentCommentDto {
    public String comment;
    public Integer usersId;
    public Integer contentId;

   // private Integer contentId;

    public ContentComment toContentComment(Users users, Content content) {
    return new ContentComment()

            .setUsers(users)
            .setComment(comment)
            .setContent(content);

    }
}
