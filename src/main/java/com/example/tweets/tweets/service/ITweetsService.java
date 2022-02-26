package com.example.tweets.tweets.service;

import com.example.tweets.tweets.model.tweets;

import java.util.Date;
import java.util.List;

public interface ITweetsService {
    List<tweets> findAll();
    List<tweets> findByUserID(int userid);
    void addTweet(tweets tweet);
}
