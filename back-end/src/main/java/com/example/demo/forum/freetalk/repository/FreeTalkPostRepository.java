package com.example.demo.forum.freetalk.repository;

import com.example.demo.forum.freetalk.entity.FreeTalkPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeTalkPostRepository extends JpaRepository<FreeTalkPost, Long> {
}
