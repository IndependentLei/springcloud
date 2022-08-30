package com.example.seatastorageservice2002.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Storage;
import com.example.seatastorageservice2002.Service.StorageService;
import com.example.seatastorageservice2002.dao.StorageDao;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageDao, Storage> implements StorageService {

    @Override
    public Boolean subtract(Long productId, Integer count) {
        Storage storage = this.getOne(new LambdaQueryWrapper<Storage>().eq(Storage::getProductId, productId));
        if(storage.getResidue() < count){
            return false;
        }
        storage.setResidue(storage.getResidue() - count);
        storage.setUsed(storage.getUsed() + count);
        return this.updateById(storage);
    }
}
