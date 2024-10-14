package com.Quiz.Controller;

import com.Quiz.Dao.Question;
import com.Quiz.Dao.QuestionWrapper;
import com.Quiz.Dao.Quiz;
import com.Quiz.Service.quizService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

   @Autowired
    quizService quizService;
//creating Quiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam int numQ, @RequestParam String title)
    {
        return quizService.CreateQuiz(numQ,title);

    }

   //Get Quiz
    @GetMapping("getquiz/{id}")
   public ResponseEntity<List<QuestionWrapper>>getQuiz(@PathVariable Integer id)
   {

       return quizService.getQuiz(id);

   }

}
