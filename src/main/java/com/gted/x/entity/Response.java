package com.gted.x.entity;

/**
 * Created by Вадим on 27.09.2017.
 */

public class Response<T> {


    private Integer code;

    private String message;

    private JobCallBackEntity job;


    public Response() {
    }

    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(JobCallBackEntity job) {
        this.job = job;
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

    public JobCallBackEntity getJob() {
        return job;
    }

    public void setJob(JobCallBackEntity job) {
        this.job = job;
    }
}
