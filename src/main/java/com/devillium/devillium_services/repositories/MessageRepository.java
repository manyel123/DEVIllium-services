package com.devillium.devillium_services.repositories;

import com.devillium.devillium_services.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// Repositories extends MongoRepository using <Model, IDType> sentence
public interface MessageRepository extends MongoRepository <Message, String> {

    // Method for listing sent messages
    List<Message> findByUsernameOrigin (String usernameOrigin);

    // Method for listing received messages
    List<Message> findByUsernameDestiny (String usernameDestiny);

    // Method for listing all messages
    List<Message> findAll();
}
