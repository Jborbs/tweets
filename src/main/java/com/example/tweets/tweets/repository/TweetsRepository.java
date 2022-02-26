package com.example.tweets.tweets.repository;

import com.example.tweets.tweets.model.tweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TweetsRepository extends JpaRepository<tweets, Integer> {

    List<tweets> findByUserid(int userID);

    @Query("SELECT t FROM tweets t where t.userid <> ?1")
    List<tweets> findByUseridNotLike(int userID);
}
