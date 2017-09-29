package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Вадим on 27.09.2017.
 */
@Embeddable
public class Headers {

    @Column(name = "content_type")
    @JsonProperty("Content-Type")
    private String contentType;

    @Column(name = "accept")
    @JsonProperty("Accept")
    private String accept;

    @Column(name = "authorization")
    @JsonProperty("Authorization")
    private String authorization;

    public Headers() {
    }

    public Headers(String contentType, String accept, String authorization) {
        this.contentType = contentType;
        this.accept = accept;
        this.authorization = authorization;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }


    @Override
    public String toString() {
        return "Headers{" +
                "contentType='" + contentType + '\'' +
                ", accept='" + accept + '\'' +
                ", authorization='" + authorization + '\'' +
                '}';
    }
}
