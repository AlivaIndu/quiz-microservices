package com.project.quiz_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class questionWrapper {
    private int id;
    private String questiontitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
