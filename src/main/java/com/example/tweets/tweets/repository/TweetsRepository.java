package com.example.tweets.tweets.repository;

import com.example.tweets.tweets.model.tweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface TweetsRepository extends JpaRepository<tweets, Integer> {

}
