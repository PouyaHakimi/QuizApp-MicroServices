package com.pouya.Question.Service_Microservices.Model;

//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//
//@Data
//@Entity
//@Table(name="question")
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class Question {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
//    private String category;
//    private String difficultLevel;
//    private String option1;
//    private String option2;
//    private String option3;
//    private String option4;
//    private String questionTitle;
//    private String rightAnswer;
//
//}

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String category;
    private String difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulytLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultLevel) {
        this.difficultyLevel = difficultLevel;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
