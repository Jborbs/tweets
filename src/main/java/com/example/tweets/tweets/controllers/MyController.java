package com.example.tweets.tweets.controllers;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.model.tweets;
import com.example.tweets.tweets.service.IAccountsService;
import com.example.tweets.tweets.service.IEncryptionService;
import com.example.tweets.tweets.service.ITweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
class MyController {

    @Autowired
    private IAccountsService accountsService;

    @Autowired
    private ITweetsService tweetsService;

    @Autowired
    private IEncryptionService encryptionService;


/*    @RequestMapping(value = "/accounts")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView ListAccounts(ModelAndView model) {
        List<accounts> listAccounts = accountsService.findAll();
        model.addObject("listAccounts", listAccounts);
        model.setViewName("account");
        return model;
    }*/

/*    @RequestMapping("/tweets")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView ListTweets(ModelAndView model) {
        List<tweets> listTweets = tweetsService.findAll();
        model.addObject("listTweets", listTweets);
        model.setViewName("tweets");
        return model;
    }*/

    @RequestMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView loginHome(ModelAndView model) {
        model.setViewName("loginPage");
        return model;
    }

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response, ModelAndView modelAndView) {
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String message;

        List<String> userPwdSalt = accountsService.findPasswordSaltByUsername(userName);
        String expectedPassword = userPwdSalt.get(0);
        String expectedSalt = userPwdSalt.get(1);

        if(encryptionService.verifyUserPassword(password, expectedPassword, expectedSalt)){
            message = "Welcome " + userName + ".";
            modelAndView.addObject("message", message);
            modelAndView.addObject("username", userName);
            List<tweets> listTweets = tweetsService.findAll();
            modelAndView.addObject("listTweets", listTweets);
            modelAndView.setViewName("userpage");

        }else{
            message = "Wrong username or password.";
             new ModelAndView("errorPage",
                    "message", message);
            modelAndView.addObject("message", message);
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }


    @RequestMapping("/userpage")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView loginHome( ModelAndView model, HttpServletRequest request) {
       // System.out.println(userID);
        List<tweets> listTweets = tweetsService.findAll();
        model.addObject("listTweets", listTweets);
        model.setViewName("userpage");
        return model;
    }

    @PostMapping("/addTweet")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView addTweet(HttpServletRequest request,
                              HttpServletResponse response, ModelAndView modelAndView) {
        String tweetMessage=request.getParameter("tweetMessage");

        tweets tempTweet = new tweets();
        tempTweet.setTweetdata(tweetMessage);
        tempTweet.setDateposted(DateUtils.createToday().getTime());

        //TODO need to pull user id by username
        tempTweet.setUserID(1);

        tweetsService.addTweet(tempTweet);
        modelAndView.setViewName("userpage");
        return modelAndView;
    }
    @RequestMapping("/myTweets")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView myTweets( ModelAndView model, HttpServletRequest request) {
        // System.out.println(userID);
        List<tweets> listTweets = tweetsService.findAll();
        model.addObject("listTweets", listTweets);
        model.setViewName("MyTweets");
        return model;
    }

    @RequestMapping("/createTweet")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView createTweet( ModelAndView model, HttpServletRequest request) {
        model.setViewName("CreateTweet");
        return model;
    }

}
