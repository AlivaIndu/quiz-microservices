package com.project.quiz_service.services;

import com.project.quiz_service.feign.quizInterface;
import com.project.quiz_service.model.Answer;
import com.project.quiz_service.model.questionWrapper;
import com.project.quiz_service.model.quiz;
import com.project.quiz_service.repositories.quizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {
    @Autowired
    quizRepository quizRepository;

    @Autowired
    quizInterface quizInterface;

    public String createQuiz(String category, int numQ, String title) {
        List<Integer> ques = quizInterface.GenerateQuestion(category, numQ).getBody();
        System.out.println("CATEGORY SENT: [" + category + "]");
        System.out.println("NUM QUESTIONS: " + numQ);
        System.out.println("QUESTION IDS RECEIVED: " + ques);

        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(ques);

        quizRepository.save(quiz);

        return "Success";
    }

    public ResponseEntity<List<questionWrapper>> startQuiz(String id) {
        Optional<quiz> quiz = quizRepository.findById(Integer.valueOf(id));

        List<Integer> questionids = quiz.get().getQuestionIds();
        List<questionWrapper> questionWrappers = quizInterface.getQuestions(questionids).getBody();

        return ResponseEntity.ok(questionWrappers);
    }

    public ResponseEntity<String> submitQuiz(String id, List<Answer> answers) {
        return quizInterface.GetScore(answers);
    }
}
