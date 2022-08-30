package com.example.seataaccountservice2003.controller;

import com.example.pojo.Account;
import com.example.pojo.CommentResult;
import com.example.seataaccountservice2003.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    AccountService accountService;


    @PostMapping("/update")
    public CommentResult<Boolean> updateAccount(@RequestBody Account account){
        return new CommentResult<>(200,"ok",accountService.updateById(account));
    }
}
