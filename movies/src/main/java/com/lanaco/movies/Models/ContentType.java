package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(name = "content_type",schema = "public")
@Accessors(chain = true)
public class ContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContentTypeId")
    private int contentTypeId;

    private String name;
}
