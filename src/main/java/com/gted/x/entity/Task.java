package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.*;
import javax.validation.Valid;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


@Embeddable
public class Task {

    @Column(name = "method")
    @Enumerated(value = EnumType.STRING)
    @JsonProperty("method")
    private RequestMethod  method;

    @Column(name = "url")
    @JsonProperty("url")
    private String url;

    @Embedded
    @Valid
    @JsonProperty("headers")
    private Headers headers;

    @Column(name = "data")
    @JsonProperty("data")
    private String data;

    public Task() {
        this.headers = new Headers();
        this.url = "";
        this.data="";

    }

    public Task(RequestMethod method, String url, Headers headers, String data) {
        this();
        setMethod(method);
        setUrl(url);
        setHeaders(headers);
        setData(data);
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = isNotBlank(url) ? url : "";
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers == null ? new Headers() : headers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = isNotBlank(data) ? data : "";
    }

    @Override
    public String toString() {
        return "Task{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", headers=" + headers +
                ", data='" + data + '\'' +
                '}';
    }
}

