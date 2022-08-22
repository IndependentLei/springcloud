package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommentResult(Integer code , String msg){
        this(code,msg,null);
    }
}
