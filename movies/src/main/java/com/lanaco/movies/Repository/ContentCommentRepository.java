package com.lanaco.movies.Repository;

import com.lanaco.movies.Models.ContentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentCommentRepository extends JpaRepository<ContentComment,Integer> {
    List<ContentComment>findAllByCommentId(int Id);
}
