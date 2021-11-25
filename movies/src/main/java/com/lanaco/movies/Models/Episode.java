package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table (name = "episode",schema = "public")
@Accessors(chain = true)
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "episodeId")
    public int episodeId;
    @ManyToOne
    @JoinColumn(name = "seasonId")
    public Season season;
    public String name;
    public int duration;
    public int episodeNumber;
}
