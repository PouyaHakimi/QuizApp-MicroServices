package com.pouya.Question.Service_Microservices.service;

import com.pouya.Question.Service_Microservices.DAO.QuestionDao;
import com.pouya.Question.Service_Microservices.Model.Question;
import com.pouya.Question.Service_Microservices.Model.QuestionAnswer;
import com.pouya.Question.Service_Microservices.Model.QuestionWraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>>getAllQuestions(){

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> findByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategoryIgnoreCase(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);

       return new ResponseEntity<String>( "success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> generateQuestionForQuiz(String category, Integer numQ) {
        List<Integer> questionIDs = questionDao.getRandomQuestion(category,numQ);
        return new ResponseEntity<>(questionIDs,HttpStatus.OK) ;
    }

    public ResponseEntity<List<QuestionWraper>> getQuestionsForQuiz(List<Integer> questionIds) {

        List<Question> questions = new ArrayList<>();

        for(Integer id:questionIds) {
            questions.add(questionDao.findById(id).get());
        }

        List<QuestionWraper> questionWrapper = new ArrayList<>();


        for( Question question :questions ){
            QuestionWraper Qw = new QuestionWraper();

           Qw.setId(question.getId());
           Qw.setOption1(question.getOption1());
            Qw.setOption2(question.getOption2());
            Qw.setOption3(question.getOption3());
            Qw.setOption4(question.getOption4());
            Qw.setQuestionTitle(question.getQuestionTitle());

            questionWrapper.add(Qw);
        }

        return new ResponseEntity<>(questionWrapper ,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateresult(List<QuestionAnswer> answers) {
        int rightAnswer = 0;
        for(QuestionAnswer answer : answers) {
            Question question =questionDao.findById(answer.getId()).get();
            if(question.getRightAnswer().equals(answer.getAnswer())){
              rightAnswer++;
            }
        }



        return new ResponseEntity<>(rightAnswer , HttpStatus.OK);
    }


//    public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer numberOfQuestions) {
//        List<Integer> questions =  questionDao.findRandomQuestionsForQuiz(category,numberOfQuestions);
//        return new ResponseEntity<>(questions,HttpStatus.OK);
//    }

//    public ResponseEntity<List<QuestionWraper>> getQuestionsFromId(List<Integer> questionIds) {
//
//        List<QuestionWraper> questionWrapper = new ArrayList<>();
//        List<Question> questions = new ArrayList<>();
//
//        for (  Integer id : questionIds){
//            questions.add(questionDao.findById(id).get());
//        }
//        int i = 0 ;
//
//        for(Question question : questions){
//            QuestionWraper wrapper =new QuestionWraper();
//            wrapper.setId(question.getId());
//            wrapper.setQuestionTitle(question.getQuestionTitle());
//            wrapper.setOption1(question.getOption1());
//            wrapper.setOption2(question.getOption2());
//            wrapper.setOption3(question.getOption3());
//            wrapper.setOption4(question.getOption4());
//            questionWrapper.add(wrapper);
//        }
//
//        return new ResponseEntity<>(questionWrapper,HttpStatus.OK);
//    }
}


