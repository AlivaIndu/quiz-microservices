package com.project.question_service.services;

import com.project.question_service.model.Answer;
import com.project.question_service.model.questionWrapper;
import com.project.question_service.model.questions;
import com.project.question_service.repositories.questionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService {
    @Autowired
    questionRepository questionRepository;

    public List<questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    public questions addQuestion(questions que) {
        return questionRepository.save(que);
    }

    public List<questions> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category.toUpperCase());
    }

    public ResponseEntity<List<Integer>> GenerateQuestion(String category, int numQ) {
        List<Integer> ques = questionRepository.GenerateQuestion(category.toUpperCase(),numQ);
        return ResponseEntity.ok().body(ques);
    }

    public ResponseEntity<List<questionWrapper>> getQuestions(List<Integer> ques) {
        List<questionWrapper> questionWrappers = new ArrayList<>();
        
        List<questions> questions = new ArrayList<>();
        for(Integer id:ques){
            questions.add(questionRepository.findById(id).get());
        }
        
        for (questions q : questions) {
            questionWrapper qw = new questionWrapper();
            qw.setId(q.getId());
            qw.setQuestiontitle(q.getQuestiontitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            questionWrappers.add(qw);
        }
        
        return ResponseEntity.ok().body(questionWrappers);
    }

    public ResponseEntity<String> getScore(List<Answer> answers) {
        int result = 0;
        for(Answer ans:answers){
            questions que = questionRepository.findById(Integer.valueOf(ans.getId())).get();
            if(ans.getAnswer().equals(que.getCorrectanswer()))
                result++;
        }
        String output = "Your score is " + result +" out of "+answers.size();
        return ResponseEntity.ok(output);
    }
}
