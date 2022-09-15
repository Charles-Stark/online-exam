package com.example.backend.Vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    private int code;
    private String msg;
    private T data;

    public ResultVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
