package com.example.seataorderservice2001.service;

import com.example.pojo.Account;
import com.example.pojo.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping("/account/update")
    public CommentResult<Boolean> updateAccount(@RequestBody Account account);
}
