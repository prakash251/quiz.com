package com.Quiz.Service;

import com.Quiz.Dao.Question;
import com.Quiz.Dao.QuestionWrapper;
import com.Quiz.Dao.Quiz;
import com.Quiz.Dao.Response;
import com.Quiz.Repo.QuestionRepo;
import com.Quiz.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> CreateQuiz(int numQ, String title) {


      List<Question> ques =questionRepo.findQuestionsByLimit(numQ);

        Quiz quiz=new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestions(ques);
        quizRepo.save(quiz);

        return new ResponseEntity<>("creatd Quiz", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        Optional<Quiz> qzs = quizRepo.findById(id);
        List<Question> questionsFromDb=qzs.get().getQuestions();
         List<QuestionWrapper>  questionsFroUser= new ArrayList<>();

         for(Question q:questionsFromDb){

             QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuetionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
              questionsFroUser.add(qw);

         }

        return new ResponseEntity<>(questionsFroUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> response) {
          Quiz qz=quizRepo.findById(id).get();

        List<Question> questionsa  =qz.getQuestions();
        Integer right=0;
        int i=0;
        for(Response res:response)
        {
            if (res.getResponse().equals(questionsa.get(i).getCorrectAnswer())){
                right++;
            }

            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
