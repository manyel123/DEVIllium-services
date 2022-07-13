package com.devillium.devillium_services.repositories;

import com.devillium.devillium_services.models.DevPublications;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// Repositories extends MongoRepository using <Model, IDType> sentence
public interface DevPublicationsRepository extends MongoRepository <DevPublications, String>{

    // Method which looks for user publications, using its username
    List<DevPublications> findByUsername (String username);

    // Method for listing all publications
    List<DevPublications> findAll();
}
