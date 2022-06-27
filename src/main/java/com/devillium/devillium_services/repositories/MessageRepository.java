package com.devillium.devillium_services.repositories;

import com.devillium.devillium_services.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository <Message, String> {
    List<Message> findByUsernameOrigin (String usernameOrigin);
    List<Message> findByUsernameDestiny (String usernameDestiny);
    List<Message> findAll();
}
