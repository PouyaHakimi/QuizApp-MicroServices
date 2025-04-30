package com.pouya.Question.Service_Microservices.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionAnswer {
    public QuestionAnswer(Integer id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String answer;
}
