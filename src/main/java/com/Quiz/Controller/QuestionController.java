package com.Quiz.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quetions")
public class QuestionController {

    @GetMapping("getq")
    public String getquestions()
    {
        return "hwy here i am sending data just catch it !!!!!";
    }
}
