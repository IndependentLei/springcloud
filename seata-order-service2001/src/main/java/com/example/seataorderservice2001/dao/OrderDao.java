package com.example.seataorderservice2001.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Order;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderDao extends BaseMapper<Order>{

}
