package com.devillium.devillium_services.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class DevPublications {

    // Entity's identifier (In spring-boot)
    @Id

    // Entity's attributes
    private String id;
    private String username;
    private String devPost;
    private Date   devPostDate;

    public DevPublications(String id, String username, String devPost, Date devPostDate) {
        this.id          = id;
        this.username    = username;
        this.devPost     = devPost;
        this.devPostDate = devPostDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDevPost() {
        return devPost;
    }

    public void setDevPost(String devPost) {
        this.devPost = devPost;
    }

    public Date getDevPostDate() {
        return devPostDate;
    }

    public void setDevPostDate(Date devPostDate) {
        this.devPostDate = devPostDate;
    }
}
