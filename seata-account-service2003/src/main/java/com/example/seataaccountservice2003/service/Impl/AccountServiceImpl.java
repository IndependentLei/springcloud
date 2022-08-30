package com.example.seataaccountservice2003.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Account;
import com.example.seataaccountservice2003.dao.AccountDao;
import com.example.seataaccountservice2003.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

}
