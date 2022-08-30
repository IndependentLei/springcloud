package com.example.seataaccountservice2003.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface AccountDao extends BaseMapper<Account>{

}
