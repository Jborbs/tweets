package com.example.tweets.tweets.model;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tweets")
public class tweets {

    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=1, allocationSize=12)
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="seq-gen")
    private Integer tweetID;
    private Integer userID;
    private String tweetdata;
    private Date dateposted;
}
