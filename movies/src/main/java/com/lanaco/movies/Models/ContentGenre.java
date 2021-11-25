package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.ContentGenreId;
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
@IdClass(ContentGenreId.class)
@Table(name = "content_genre",schema = "public")
@Accessors(chain = true)
public class ContentGenre {
    @Id
    public int contentId;
    @Id
    public int genreId;
}
