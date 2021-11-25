package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "country",schema = "public")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="countryId")
    private int countryId;

    private String name;
    private String code;

}
