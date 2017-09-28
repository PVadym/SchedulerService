package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Вадим on 28.09.2017.
 */
public class RequestBody {

    @JsonProperty("body")
    private Job job;

    public RequestBody() {
    }

    public RequestBody(Job job) {
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "job=" + job +
                '}';
    }
}
