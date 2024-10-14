package com.Quiz.Repo;


import com.Quiz.Dao.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {

    @Query(value = "SELECT * FROM Question q ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findQuestionsByLimit(int numQ);

//
//    List<Question> findQuietionsbyLimt(int numQ);
}
