package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "language",schema = "public")
@Accessors(chain = true)
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "languageId")
    public int languageId;

    public String name;
    public  String code;

}
