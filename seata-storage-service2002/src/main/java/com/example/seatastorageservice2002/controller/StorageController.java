package com.example.seatastorageservice2002.controller;

import com.example.pojo.CommentResult;
import com.example.pojo.Storage;
import com.example.seatastorageservice2002.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @PostMapping("/update")
    public CommentResult<Boolean> updateStorage(@RequestBody Storage storage){
        return new CommentResult<>(200,"ok",storageService.updateById(storage));
    }
}
