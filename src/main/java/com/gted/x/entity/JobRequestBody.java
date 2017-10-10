package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class JobRequestBody {

    @JsonProperty("body")
    private JobEntity jobEntity;

    public JobRequestBody() {
    }

    public JobRequestBody(JobEntity jobEntity) {
    }

    public JobEntity getJobEntity() {
        return jobEntity;
    }

    public void setJobEntity(JobEntity jobEntity) {
        this.jobEntity = jobEntity;
    }

    @Override
    public String toString() {
        return "JobRequestBody{" +
                "jobEntity=" + jobEntity +
                '}';
    }
}
