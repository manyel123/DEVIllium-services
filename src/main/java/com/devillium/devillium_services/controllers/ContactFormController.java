package com.devillium.devillium_services.controllers;

import com.devillium.devillium_services.exceptions.ContactFormNotFoundException;
import com.devillium.devillium_services.models.ContactForm;
import com.devillium.devillium_services.repositories.ContactFormRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Spring-boot controller decorator for dependencies injection
@RestController

public class ContactFormController {

    private final ContactFormRepository contactFormRepository;

    public ContactFormController(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    // Creating a new contact form
    @PostMapping("/newContactForm")
    ContactForm newContactForm(@RequestBody ContactForm contactForm){
        contactForm.setContactFormDate(new Date());
        contactForm.setContactFormReviewed(false);
        return contactFormRepository.save(contactForm);
    }

    // Getting a list of reviewed or not reviewed contact forms
    @GetMapping("/contactForms/reviewed/{contactFormReviewed}")
    List <ContactForm> getContactForms(@PathVariable boolean contactFormReviewed) {
        List <ContactForm> contactForms =
                contactFormRepository.findByContactFormReviewed(
                        contactFormReviewed).stream().collect(Collectors.toList());
        if (contactForms.isEmpty())
            throw new ContactFormNotFoundException("No hay formularios para revisar");
        return contactForms;
    }

    // Getting all forms
    @GetMapping("/contactForms/all")
    List <ContactForm> getAllContactForms() {
        return contactFormRepository.findAll();
    }
}
