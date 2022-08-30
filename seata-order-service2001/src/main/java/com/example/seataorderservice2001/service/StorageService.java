package com.example.seataorderservice2001.service;

import com.example.pojo.CommentResult;
import com.example.pojo.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping("/storage/update")
    public CommentResult<Boolean> updateStorage(@RequestBody Storage storage);
}
