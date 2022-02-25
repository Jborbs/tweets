package com.example.tweets.tweets.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tweets")
public class tweets {

    @Id
    private Integer tweetID;
    private Integer userID;
    private String tweetdata;
    private Date dateposted;
}
