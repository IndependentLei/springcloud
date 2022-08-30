package com.example.seataorderservice2001.service;

import com.example.pojo.Account;
import com.example.pojo.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping("/account/update")
    public CommentResult<Boolean> updateAccount(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
