package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.*;
import java.net.URL;

/**
 * Created by Вадим on 27.09.2017.
 */
@Embeddable
public class Task {


    @Column(name = "method")
    @Enumerated(value = EnumType.STRING)
    @JsonProperty("method")
    private RequestMethod  method;


    @Column(name = "url")
    @JsonProperty("url")
    private URL url;

    @Embedded
    @JsonProperty("headers")
    private Headers headers;

    @Column(name = "data")
    @JsonProperty("data")
    private String data;

    public Task() {
    }

    public Task(RequestMethod method, URL url, Headers headers, String data) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.data = data;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

