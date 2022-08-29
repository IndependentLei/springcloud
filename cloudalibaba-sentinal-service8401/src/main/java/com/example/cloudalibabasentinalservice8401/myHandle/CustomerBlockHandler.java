package com.example.cloudalibabasentinalservice8401.myHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.pojo.CommentResult;

/**
 * @Description :
 * @ClassName : CustomerBlockHandler
 * @Author : jdl
 * @Create : 2022-08-28 22:14
 */
public class CustomerBlockHandler {
    public static CommentResult<String> handleException1(BlockException ex){
        return new CommentResult<>(444,"按照客户自定义，golbal exception","---1---");
    }

    public static CommentResult<String> handleException2(BlockException ex){
        return new CommentResult<>(444,"按照客户自定义，golbal exception","---2---");
    }
}
