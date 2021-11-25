package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.ReviewId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@IdClass(ReviewId.class)
@Accessors(chain = true)
@Table(name = "review",schema = "public")
public class Review {
@Id
   public int userId;
@Id
    public int contentId;

    public int rating;
    public boolean favorite;
}
