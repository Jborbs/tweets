package com.example.tweets.tweets.service;

public interface IEncryptionService {
    boolean verifyUserPassword(String providedPassword,String securedPassword, String salt);
}
