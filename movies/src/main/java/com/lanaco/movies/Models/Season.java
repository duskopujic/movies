package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "season",schema = "public")
@Accessors(chain = true)
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seasonId")
    public int seasonId;
    @ManyToOne
    @JoinColumn(name = "contentId")
    public Content content;
    public String name;
    public int seasonNumber;
}
