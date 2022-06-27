package com.devillium.devillium_services.repositories;

import com.devillium.devillium_services.models.DevPublications;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DevPublicationsRepository extends MongoRepository <DevPublications, String>{
    List<DevPublications> findByUsername (String username);
    List<DevPublications> findAll();
}
