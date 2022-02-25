package com.example.tweets.tweets.controllers;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.model.tweets;
import com.example.tweets.tweets.service.IAccountsService;
import com.example.tweets.tweets.service.ITweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
class MyController {

    @Autowired
    private IAccountsService accountsService;

    @Autowired
    private ITweetsService tweetsService;

    @RequestMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public String hello(Model model) {
        String response = "hello";
        model.addAttribute("helloName", response);
        return "home";
    }

    @RequestMapping(value = "/accounts")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView ListAccounts(ModelAndView model) {
        List<accounts> listAccounts = accountsService.findAll();
        model.addObject("listAccounts", listAccounts);
        model.setViewName("account");
        return model;
    }

    @RequestMapping("/tweets")
    @ResponseStatus(value = HttpStatus.OK)
    public ModelAndView ListTweets(ModelAndView model) {
        List<tweets> listTweets = tweetsService.findAll();
        model.addObject("listTweets", listTweets);
        model.setViewName("tweets");
        return model;
    }

    /*@RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String message;

        //ToDo Change to query from db
        if(userName != null &&
                !userName.equals("")
                && userName.equals("jai") &&
                password != null &&
                !password.equals("") &&
                password.equals("123")){
            message = "Welcome " +userName + ".";
            return new ModelAndView("welcome",
                    "message", message);

        }else{
            message = "Wrong username or password.";
            return new ModelAndView("errorPage",
                    "message", message);
        }
    }*/
}
