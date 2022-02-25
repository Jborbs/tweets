package com.example.tweets.tweets.repository;

import com.example.tweets.tweets.model.tweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepository extends JpaRepository<tweets, Integer> {
}
