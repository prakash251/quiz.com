package com.Quiz.Controller;

import com.Quiz.Dao.QuestionWrapper;
import com.Quiz.Dao.Response;
import com.Quiz.Service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
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

   //submitting Answers
    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitResponse(@PathVariable Integer id,@RequestBody List<Response> response){
        return  quizService.submitQuiz(id,response);
    }

}
