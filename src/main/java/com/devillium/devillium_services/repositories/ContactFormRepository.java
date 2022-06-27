package com.devillium.devillium_services.repositories;

import com.devillium.devillium_services.models.ContactForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ContactFormRepository extends MongoRepository <ContactForm, String> {
    List<ContactForm> findByContactFormReviewed (Boolean contactFormReviewed);
    List<ContactForm> findAll();
}
