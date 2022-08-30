package com.example.seataaccountservice2003.controller;

import com.example.pojo.Account;
import com.example.pojo.CommentResult;
import com.example.seataaccountservice2003.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    AccountService accountService;


    @PostMapping("/update")
    public CommentResult<Boolean> updateAccount(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        return new CommentResult<>(200,"ok",accountService.subtract(userId,money));
    }
}
