package com.devillium.devillium_services.controllers;

import com.devillium.devillium_services.exceptions.MessagesNotFoundException;
import com.devillium.devillium_services.models.Message;
import com.devillium.devillium_services.repositories.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Spring-boot controller decorator for dependencies injection
@RestController

public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Getting all sent messages by username
    @GetMapping("/messages/sent/{usernameOrigin}")
    List <Message> getSentMessages(@PathVariable String usernameOrigin) {
        List <Message> messagesOrigin =
                messageRepository.findByUsernameOrigin(usernameOrigin).stream().collect(Collectors.toList());
        if (messagesOrigin.isEmpty())
            throw new MessagesNotFoundException("No hay mensajes para mostrar");
        return messagesOrigin;
    }

    // Getting all received messages by username
    @GetMapping("/messages/received/{usernameDestiny}")
    List <Message> getReceivedMessages(@PathVariable String usernameDestiny) {
        List <Message> messagesDestiny =
                messageRepository.findByUsernameDestiny(usernameDestiny).stream().collect(Collectors.toList());
        if (messagesDestiny.isEmpty())
            throw new MessagesNotFoundException("No hay mensajes para mostrar");
        return messagesDestiny;
    }

    // Creating-sending a new message
    @PostMapping("/messages")
    Message newMessage(@RequestBody Message message){
        message.setSentDate(new Date());
        return messageRepository.save(message);
    }

    // Getting all messages
    @GetMapping("/messages/all")
    List <Message> getAllMessages(){
        return messageRepository.findAll();
    }
}
