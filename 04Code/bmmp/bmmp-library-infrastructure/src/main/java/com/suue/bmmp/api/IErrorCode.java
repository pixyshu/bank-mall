package com.suue.bmmp.api;

/**
 * 封装API的错误码
 * Created by shuds on 2022/3/1
 **/
public interface IErrorCode {
    long getCode();

    String getMessage();
}
