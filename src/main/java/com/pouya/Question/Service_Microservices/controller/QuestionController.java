package com.pouya.Question.Service_Microservices.controller;


import com.pouya.Question.Service_Microservices.Model.Question;
import com.pouya.Question.Service_Microservices.Model.QuestionAnswer;
import com.pouya.Question.Service_Microservices.Model.QuestionWraper;
import com.pouya.Question.Service_Microservices.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")

public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("AllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return  questionService.getAllQuestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Question>> getQusetionByCategory(@PathVariable("cat") String category){
        return questionService.findByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }

//    @GetMapping("generate")
//    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category , @RequestParam Integer numberOfQuestions ){
//        return questionService.getQuestionForQuiz(category,numberOfQuestions);
//    }
//
//    @PostMapping
//    public ResponseEntity<List<QuestionWraper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
//        return questionService.getQuestionsFromId(questionIds);
//    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category ,@RequestParam(name="numQ") Integer NumQ ){
        return questionService.generateQuestionForQuiz(category,NumQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWraper>> getQuestionsForQuiz(@RequestBody List<Integer> questionIds){
        return questionService.getQuestionsForQuiz(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> quizResult(@RequestBody List<QuestionAnswer> answers ){
        return questionService.calculateresult(answers);
    }


}
