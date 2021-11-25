package com.lanaco.movies.Models;

import com.lanaco.movies.Models.CompositeKeys.SerieCastId;
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
@IdClass(SerieCastId.class)
@Table(name = "serie_cast",schema = "public")
@Accessors(chain = true)
public class SerieCast {
    @Id
    public int movieRoleId;
    @Id
    public int moviePeopleId;
    @Id
    public int seasonId;
}
