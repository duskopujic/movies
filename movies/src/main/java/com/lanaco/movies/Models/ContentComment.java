package com.lanaco.movies.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.swing.text.AbstractDocument;

@Data
@NoArgsConstructor
@Entity
@Accessors(chain = true)
@Table(name = "content_comment", schema = "public")
public class ContentComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentId")
    private int commentId;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "usersId")
    private Users users;
    @ManyToOne
    @JoinColumn(name ="contentId" )
    private Content content;
}
