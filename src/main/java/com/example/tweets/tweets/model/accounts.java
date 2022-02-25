package com.example.tweets.tweets.model;

import lombok.Data;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "accounts")
public class accounts {

    @Id
    private Integer user_id;
    private String username;
    private String email;
    private Date created_on;
    private Date last_login;
    private String salt;
    private String password;
}
