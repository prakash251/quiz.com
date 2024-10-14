package com.Quiz.Controller;


import com.Quiz.Dao.Question;
import com.Quiz.Service.QuestionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return  questionService.addQuestions();
    }

    @DeleteMapping("delete/{id}")
   public ResponseEntity<String> deleteQuestionByid(@PathVariable int  id)
   {
       return  questionService.deleQuestion(id);
   }

   @DeleteMapping("deleteall")
   public ResponseEntity<String> deleteAllQuestions()
   {
       return questionService.deleteAllQuestions();
   }
}
