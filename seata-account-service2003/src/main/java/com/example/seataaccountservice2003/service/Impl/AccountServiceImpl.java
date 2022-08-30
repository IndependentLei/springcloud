package com.example.seataaccountservice2003.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Account;
import com.example.seataaccountservice2003.dao.AccountDao;
import com.example.seataaccountservice2003.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

    @Override
    public Boolean subtract(Long userId, Long money) {
        Account account = this.getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId),false);
        if(account.getResidue().compareTo(money) < 0){
            return Boolean.FALSE;
        }
        account.setUsed(account.getUsed()+money);
        account.setResidue(account.getResidue()-money);
        return this.updateById(account);
    }
}
