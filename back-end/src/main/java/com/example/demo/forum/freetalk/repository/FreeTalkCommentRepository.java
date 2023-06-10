package com.example.demo.forum.freetalk.repository;

import com.example.demo.forum.freetalk.entity.FreeTalkComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeTalkCommentRepository extends JpaRepository<FreeTalkComment, Long> {
}
