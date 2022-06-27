package com.devillium.devillium_services.models;

import  org.springframework.data.annotation.Id;
import java.util.Date;

public class Message {
    @Id
    private String id;
    private String usernameOrigin;
    private String usernameDestiny;
    private String post;
    private Date   sentDate;

    public Message(String id, String usernameOrigin, String usernameDestiny, String post, Date sentDate) {
        this.id              = id;
        this.usernameOrigin  = usernameOrigin;
        this.usernameDestiny = usernameDestiny;
        this.post            = post;
        this.sentDate        = sentDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernameOrigin() {
        return usernameOrigin;
    }

    public void setUsernameOrigin(String usernameOrigin) {
        this.usernameOrigin = usernameOrigin;
    }

    public String getUsernameDestiny() {
        return usernameDestiny;
    }

    public void setUsernameDestiny(String usernameDestiny) {
        this.usernameDestiny = usernameDestiny;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }
}
