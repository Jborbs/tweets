package com.example.tweets.tweets.controllers;

import com.example.tweets.tweets.model.accounts;
import com.example.tweets.tweets.model.tweets;
import com.example.tweets.tweets.service.IAccountsService;
import com.example.tweets.tweets.service.ITweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/loginPage")
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

        String actualPassword = accountsService.findPasswordByUsername(userName);

        if(password.equals(actualPassword)){
            message = "Welcome " + userName + ".";
            modelAndView.addObject("message", message);
            modelAndView.addObject("User", userName);
            modelAndView.setViewName("userpage");
            return modelAndView;

        }else{
            message = "Wrong username or password.";
             new ModelAndView("errorPage",
                    "message", message);
            modelAndView.addObject("message", message);
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}
