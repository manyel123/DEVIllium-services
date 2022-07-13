package com.devillium.devillium_services.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class ContactForm {
    
    // Entity's identifier (In spring-boot)
    @Id

    // Entity's attributes
    private String  id;
    private String  contactFormName;
    private String  contactFormOrganization;
    private String  contactFormPhone;
    private String  contactFormEmail;
    private String  contactFormPost;
    private Date    contactFormDate;
    private Boolean contactFormReviewed;

    public ContactForm(String id, String contactFormName, String contactFormOrganization,
                       String contactFormPhone, String contactFormEmail, String contactFormPost,
                       Date contactFormDate, Boolean contactFormReviewed) {
        this.id                      = id;
        this.contactFormName         = contactFormName;
        this.contactFormOrganization = contactFormOrganization;
        this.contactFormPhone        = contactFormPhone;
        this.contactFormEmail        = contactFormEmail;
        this.contactFormPost         = contactFormPost;
        this.contactFormDate         = contactFormDate;
        this.contactFormReviewed     = contactFormReviewed;
    }

    public Boolean isContactFormReviewed() {
        return contactFormReviewed;
    }

    public void setContactFormReviewed(boolean contactFormReviewed) {
        this.contactFormReviewed = contactFormReviewed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactFormName() {
        return contactFormName;
    }

    public void setContactFormName(String contactFormName) {
        this.contactFormName = contactFormName;
    }

    public String getContactFormOrganization() {
        return contactFormOrganization;
    }

    public void setContactFormOrganization(String contactFormOrganization) {
        this.contactFormOrganization = contactFormOrganization;
    }

    public String getContactFormPhone() {
        return contactFormPhone;
    }

    public void setContactFormPhone(String contactFormPhone) {
        this.contactFormPhone = contactFormPhone;
    }

    public String getContactFormEmail() {
        return contactFormEmail;
    }

    public void setContactFormEmail(String contactFormEmail) {
        this.contactFormEmail = contactFormEmail;
    }

    public String getContactFormPost() {
        return contactFormPost;
    }

    public void setContactFormPost(String contactFormPost) {
        this.contactFormPost = contactFormPost;
    }

    public Date getContactFormDate() {
        return contactFormDate;
    }

    public void setContactFormDate(Date contactFormDate) {
        this.contactFormDate = contactFormDate;
    }
}
