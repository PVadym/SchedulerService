package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Вадим on 27.09.2017.
 */
public class JobBody {

    @JsonProperty("job_id")
    private Long job_Id;

    public JobBody(Long job_Id) {
        this.job_Id = job_Id;
    }

    public Long getJob_Id() {
        return job_Id;
    }

    public void setJob_Id(Long job_Id) {
        this.job_Id = job_Id;
    }

}
