package com.example.tweets.tweets.repository;


import com.example.tweets.tweets.model.accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<accounts, Integer> {
}
