package com.devillium.devillium_services.repositories;

import com.devillium.devillium_services.models.ContactForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// Repositories extends MongoRepository using <Model, IDType> sentence
public interface ContactFormRepository extends MongoRepository <ContactForm, String> {

    // Method for listing forms as reviewed or not reviewed
    List<ContactForm> findByContactFormReviewed (Boolean contactFormReviewed);

    // Method for listing all forms
    List<ContactForm> findAll();
}
