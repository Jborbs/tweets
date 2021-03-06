package com.example.tweets.tweets.service;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.model.tweets;
import com.example.tweets.tweets.repository.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TweetsService implements ITweetsService {

    @Autowired
    private TweetsRepository tweetsRepository;

    @Override
    public List<tweets> findAll() {

        List<tweets> tweets =  tweetsRepository.findAll();

        return tweets;
    }

    public List<tweets> findByUseridNotLike(int userID){
        List<tweets> tweets =  tweetsRepository.findByUseridNotLike(userID);

        return tweets;
    }

    @Override
    public List<tweets> findByUserid(int userID){
        List<tweets> tweets =  tweetsRepository.findByUserid(userID);

        return tweets;
    }

    public void addTweet(tweets tweet) {
        tweetsRepository.save(tweet);
    }

}
