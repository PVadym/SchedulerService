package com.gted.x.entity;

/**
 * Created by Вадим on 28.09.2017.
 */
public class JobResponseBody<T> {

    private T body;

    public JobResponseBody() {
    }

    public JobResponseBody(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
