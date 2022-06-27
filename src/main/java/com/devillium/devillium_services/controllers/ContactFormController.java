package com.devillium.devillium_services.controllers;

import com.devillium.devillium_services.exceptions.ContactFormNotFoundException;
import com.devillium.devillium_services.models.ContactForm;
import com.devillium.devillium_services.repositories.ContactFormRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class ContactFormController {

    private final ContactFormRepository contactFormRepository;

    public ContactFormController(ContactFormRepository contactFormRepository) {
        this.contactFormRepository = contactFormRepository;
    }

    @PostMapping("/newContactForm")
    ContactForm newContactForm(@RequestBody ContactForm contactForm){
        contactForm.setContactFormDate(new Date());
        contactForm.setContactFormReviewed(false);
        return contactFormRepository.save(contactForm);
    }

    @GetMapping("/contactForms/reviewed/{contactFormReviewed}")
    List <ContactForm> getContactForms(@PathVariable boolean contactFormReviewed) {
        List <ContactForm> contactForms =
                contactFormRepository.findByContactFormReviewed(
                        contactFormReviewed).stream().collect(Collectors.toList());
        if (contactForms.isEmpty())
            throw new ContactFormNotFoundException("No hay formularios para revisar");
        return contactForms;
    }

    @GetMapping("/contactForms/all")
    List <ContactForm> getAllContactForms() {
        return contactFormRepository.findAll();
    }
}
