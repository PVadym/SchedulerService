package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

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
        this.contentType = "application/json";
        this.accept = "application/json";
        this.authorization = "";
    }

    public Headers(String contentType, String accept, String authorization) {
        this();
        setContentType(contentType);
        setAccept(accept);
        setAuthorization(authorization);
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = isNotBlank(contentType) ? contentType : "application/json";
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = isNotBlank(accept) ? accept : "application/json";
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = isNotBlank(authorization) ? authorization : "";
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
