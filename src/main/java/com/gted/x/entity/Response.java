package com.gted.x.entity;

/**
 * Created by Вадим on 27.09.2017.
 */

public class Response<T> {


    private Integer code;

    private String message;


    public Response() {
    }

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
