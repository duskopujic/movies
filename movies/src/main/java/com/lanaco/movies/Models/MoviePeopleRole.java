package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.MoviePeopleRoleId;
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
@IdClass(MoviePeopleRoleId.class)
@Table(name = "movie_people_role",schema = "public")
@Accessors(chain = true)
public class MoviePeopleRole {
    @Id
    public int movieRoleId;
    @Id
    public int moviePeopleId;
}
