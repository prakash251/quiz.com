package com.Quiz.Controller;


import com.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quetions")
public class QuestionController {

   @Autowired
    QuestionService questionService;

    @GetMapping("getq")
    public String getquestions()
    {
        return "hwy here i am sending data just catch it !!!!!";
    }


    @PostMapping("addq")
    public ResponseEntity<String> addQuestions()
    {
        return  questionService.addQuetions();
    }

}
