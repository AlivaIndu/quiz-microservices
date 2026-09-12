package com.project.quiz_service.repositories;

import com.project.quiz_service.model.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizRepository extends JpaRepository<quiz,Integer> {
}
