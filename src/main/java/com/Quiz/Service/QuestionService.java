package com.Quiz.Service;

import com.Quiz.Dao.Question;
import com.Quiz.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {


    @Autowired
    QuestionRepo questionRepo;
    public ResponseEntity<String>   addQuetions()
    {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(1, "What is Java?", "Programming language", "Database", "Framework", "Operating System", "Programming language", "Easy"));
        questions.add(new Question(2, "Which company developed Java?", "Microsoft", "Apple", "Google", "Sun Microsystems", "Sun Microsystems", "Medium"));
        questions.add(new Question(3, "Which is a valid keyword in Java?", "volatile", "include", "main", "exit", "volatile", "Medium"));
        questions.add(new Question(4, "Which is not a primitive data type in Java?", "int", "float", "boolean", "String", "String", "Easy"));
        questions.add(new Question(5, "Which method is the entry point of a Java program?", "start()", "run()", "main()", "init()", "main()", "Easy"));
        questions.add(new Question(6, "Which of these access specifiers is the most restrictive?", "public", "protected", "private", "default", "private", "Medium"));
        questions.add(new Question(7, "Which exception is thrown when dividing by zero in Java?", "IOException", "ArithmeticException", "ArrayIndexOutOfBoundsException", "NullPointerException", "ArithmeticException", "Hard"));
        questions.add(new Question(8, "Which package contains the String class in Java?", "java.util", "java.io", "java.lang", "java.sql", "java.lang", "Medium"));
        questions.add(new Question(9, "Which keyword is used to inherit a class in Java?", "extends", "implements", "inherits", "super", "extends", "Medium"));
        questions.add(new Question(10, "Which operator is used for concatenating two strings in Java?", "+", "-", "*", "/", "+", "Easy"));


        questionRepo.saveAll(questions);
        return new ResponseEntity<>("addedd successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestions() {

     List<Question> qs=questionRepo.findAll();
     if(qs.isEmpty())
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     else
         return new ResponseEntity<>(qs,HttpStatus.OK);
    }
}