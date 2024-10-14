package com.Quiz.Controller;


import com.Quiz.Dao.Question;
import com.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

   @Autowired
    QuestionService questionService;

    @GetMapping("getq")
    public ResponseEntity<List<Question>> getquestions()
    {
        return questionService.getQuestions();
    }


    @PostMapping("addq")
    public ResponseEntity<String> addQuestions()
    {
        return  questionService.addQuetions();
    }

}
