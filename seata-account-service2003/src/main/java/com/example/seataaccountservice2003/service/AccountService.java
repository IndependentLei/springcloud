package com.example.seataaccountservice2003.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Account;

import java.math.BigDecimal;

public interface AccountService extends IService<Account> {
    Boolean subtract(Long userId, Long money);
}
