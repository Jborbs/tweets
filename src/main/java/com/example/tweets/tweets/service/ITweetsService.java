package com.example.tweets.tweets.service;

import com.example.tweets.tweets.model.tweets;

import java.util.List;

public interface ITweetsService {
    List<tweets> findAll();
}