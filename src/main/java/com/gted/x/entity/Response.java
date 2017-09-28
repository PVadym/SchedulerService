package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Вадим on 27.09.2017.
 */

public class Response {

    @JsonProperty("body")
    private JobBody body;

    public JobBody getBody() {
        return body;
    }

    public void setBody(JobBody body) {
        this.body = body;
    }

    public Response(JobBody body) {
        this.body = body;
    }
}
