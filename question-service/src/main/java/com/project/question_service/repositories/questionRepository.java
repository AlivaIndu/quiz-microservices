package com.project.question_service.repositories;

import com.project.question_service.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionRepository extends JpaRepository<questions,Integer> {
    List<questions> findByCategory(String category);

    @Query(value = "Select q.id from questions q where q.category=:category order by random() limit :numQ",nativeQuery = true)
    List<Integer> GenerateQuestion(String category, int numQ);
}
