package com.example.tweets.tweets.service;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.model.tweets;

import java.util.List;

public interface IAccountsService {
    List<accounts> findAll();
    List<String> findPasswordSaltByUsername(String username);
    accounts findByUsername(String username);
}
