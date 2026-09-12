package com.project.quiz_service.feign;

import com.project.quiz_service.model.Answer;
import com.project.quiz_service.model.questionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface quizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> GenerateQuestion(@RequestParam String category, @RequestParam int numQ);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<questionWrapper>> getQuestions(@RequestBody List<Integer> ques);

    @PostMapping("question/GetScore")
    public ResponseEntity<String> GetScore(@RequestBody List<Answer> answers) ;

}
