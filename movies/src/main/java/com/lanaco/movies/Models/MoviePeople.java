package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "movie_people", schema = "public")
@Accessors(chain = true)
public class MoviePeople {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moviePeopleId")
    public int moviePeopleId;
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public String geneder;

}
