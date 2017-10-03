package com.gted.x.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Вадим on 02.10.2017.
 */
@Embeddable
public class Result {

    @Column(name = "last_run_result_code")
    private int code;

    @Column(name = "last_run_result_body")
    private String body;

    public Result() {
        this.code = 0;
        this.body = "";
    }

    public Result(int code, String body) {
        this();
        setCode(code);
        setBody(body);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code > 0 ? code : 0;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = isNotBlank(body) ? body : "";
    }
}
