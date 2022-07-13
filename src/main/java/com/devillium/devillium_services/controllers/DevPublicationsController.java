package com.devillium.devillium_services.controllers;

import com.devillium.devillium_services.exceptions.DevPublicationsNotFoundException;
import com.devillium.devillium_services.models.DevPublications;
import com.devillium.devillium_services.repositories.DevPublicationsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Spring-boot controller decorator for dependencies injection
@RestController

public class DevPublicationsController {

    private final DevPublicationsRepository devPublicationsRepository;

    public DevPublicationsController(DevPublicationsRepository devPublicationsRepository) {
        this.devPublicationsRepository = devPublicationsRepository;
    }

    // Creating a new publication
    @PostMapping("/newDevPublication")
    DevPublications newDevPublication(@RequestBody DevPublications devPublication){
        devPublication.setDevPostDate(new Date());
        return devPublicationsRepository.save(devPublication);
    }

    // Listing all publications from a user
    @GetMapping("/devPublications/{username}")
    List <DevPublications> getDevPublications(@PathVariable String username) {
        List <DevPublications> devPublications =
                devPublicationsRepository.findByUsername(username).stream().collect(Collectors.toList());
        if (devPublications.isEmpty())
            throw new DevPublicationsNotFoundException("No hay publicaciones del desarrollador para mostrar");
        return devPublications;
    }

    // Listing all publications
    @GetMapping("/devPublications/all")
    List <DevPublications> getAllDevPublications(){
        return devPublicationsRepository.findAll();
    }
}
