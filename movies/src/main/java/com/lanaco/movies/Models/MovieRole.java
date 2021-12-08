package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "movie_role",schema = "public")
@Entity
public class MovieRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieRoleId")
    public int movieRoleId;
    public String name;
}
