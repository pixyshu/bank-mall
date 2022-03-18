package com.suue.bmmp.infrastructure.exception;

/**
 * 自定义参数异常处理类
 * Created by shuds on 2022/3/4
 **/
public class ParamaErrorException extends RuntimeException {

    public ParamaErrorException() {
    }

    public ParamaErrorException(String message) {
        super(message);
    }

}
