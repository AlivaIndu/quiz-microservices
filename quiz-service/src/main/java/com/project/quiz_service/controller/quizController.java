package com.project.quiz_service.controller;

import com.project.quiz_service.model.Answer;
import com.project.quiz_service.model.questionWrapper;
import com.project.quiz_service.model.quizdto;
import com.project.quiz_service.services.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizController {

    @Autowired
    quizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody quizdto quizdto) {
        return new ResponseEntity<>(quizService.createQuiz(quizdto.getCategory(), quizdto.getNumOfQuestions(), quizdto.getTitle()),HttpStatus.CREATED);
    }

    @GetMapping("startQuiz/{id}")
    public ResponseEntity<List<questionWrapper>> startQuiz(@PathVariable String id) {
        return quizService.startQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable String id,@RequestBody List<Answer> answers) {
        return quizService.submitQuiz(id,answers);
    }
}
