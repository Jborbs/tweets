package com.example.tweets.tweets.service;

import java.util.List;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.repository.AccountsRepository;
import com.example.tweets.tweets.service.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
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
}