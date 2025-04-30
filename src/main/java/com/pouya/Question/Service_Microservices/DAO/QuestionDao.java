package com.pouya.Question.Service_Microservices.DAO;


import com.pouya.Question.Service_Microservices.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {


    List<Question> findByCategoryIgnoreCase(String category);

    @Query(value = "select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ" ,nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

    @Query(value="select q.id from question q where q.category=:category ORDER BY RANDOM() LIMY:numQ" ,nativeQuery = true)
    List<Integer> getRandomQuestion(String category, Integer numQ);

//    @Query(value = "select q.id from question q where q.category=:category ORDER BY RANDOM() LIMIT :numberOfQuestions" ,nativeQuery = true)
//    List<Integer> findRandomQuestionsForQuiz(String category, Integer numberOfQuestions);
}
