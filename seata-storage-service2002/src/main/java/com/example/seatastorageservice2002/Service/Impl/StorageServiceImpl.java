package com.example.seatastorageservice2002.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Storage;
import com.example.seatastorageservice2002.Service.StorageService;
import com.example.seatastorageservice2002.dao.StorageDao;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {

}
