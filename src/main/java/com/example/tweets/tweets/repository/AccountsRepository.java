package com.example.tweets.tweets.repository;


import com.example.tweets.tweets.model.accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends JpaRepository<accounts, Integer> {

    @Query("SELECT password, salt FROM accounts a WHERE a.username LIKE %?1")
    String findPasswordSaltByUsername(String username);
}
