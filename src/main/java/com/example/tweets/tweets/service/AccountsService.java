package com.example.tweets.tweets.service;

import java.util.Arrays;
import java.util.List;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.model.tweets;
import com.example.tweets.tweets.repository.AccountsRepository;
import com.example.tweets.tweets.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class AccountsService implements IAccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public List<accounts> findAll() {

        List<accounts> accounts =  accountsRepository.findAll();

        return accounts;
    }

    public List<String> findPasswordSaltByUsername(String username) {
        List<String> passwordSalt = Arrays.asList(accountsRepository.findPasswordSaltByUsername(username).split(","));
        return passwordSalt;
    }

    public accounts findByUsername(String username){
        accounts account =  accountsRepository.findByUsername(username);

        return account;
    }

}