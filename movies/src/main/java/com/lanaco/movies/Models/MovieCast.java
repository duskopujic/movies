package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.MovieCastId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@IdClass(MovieCastId.class)
@Table(name = "movie_cast",schema = "public")
@Accessors(chain = true)
public class MovieCast {
    @Id
    public int contentId;
    @Id
    public int movieRoleId;
    @Id
    public int moviePeopleId;
}
