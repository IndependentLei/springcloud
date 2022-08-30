package com.example.seatastorageservice2002.controller;

import com.example.pojo.CommentResult;
import com.example.pojo.Storage;
import com.example.seatastorageservice2002.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @PostMapping("/update")
    public CommentResult<Boolean> updateStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        return new CommentResult<>(200,"ok",storageService.subtract(productId,count));
    }
}
