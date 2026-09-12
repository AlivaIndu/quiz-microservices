package com.project.question_service.controller;

import com.project.question_service.model.Answer;
import com.project.question_service.model.questionWrapper;
import com.project.question_service.model.questions;
import com.project.question_service.services.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class questionController {
    @Autowired
    private questionService questionService;

    @GetMapping("allQuestions")
    public List<questions> allQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("addQuestion")
    public questions addQuestion(@RequestBody questions que) {
        return questionService.addQuestion(que);
    }

    @GetMapping("category/{category}")
    public List<questions> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> GenerateQuestion(@RequestParam String category,@RequestParam int numQ) {
        return  questionService.GenerateQuestion(category,numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<questionWrapper>> getQuestions(@RequestBody List<Integer> ques) {
        return questionService.getQuestions(ques);
    }

    @PostMapping("GetScore")
    public ResponseEntity<String> GetScore(@RequestBody List<Answer> answers) {
        return questionService.getScore(answers);
    }
}
