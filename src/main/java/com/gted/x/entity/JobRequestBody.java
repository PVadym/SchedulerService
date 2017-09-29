package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class JobRequestBody {

    @JsonProperty("body")
    private Job job;

    public JobRequestBody() {
    }

    public JobRequestBody(Job job) {
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "JobRequestBody{" +
                "job=" + job +
                '}';
    }
}
