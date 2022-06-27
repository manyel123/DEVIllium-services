package com.devillium.devillium_services.controllers;

import com.devillium.devillium_services.exceptions.MessagesNotFoundException;
import com.devillium.devillium_services.models.Message;
import com.devillium.devillium_services.repositories.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages/sent/{usernameOrigin}")
    List <Message> getSentMessages(@PathVariable String usernameOrigin) {
        List <Message> messagesOrigin =
                messageRepository.findByUsernameOrigin(usernameOrigin).stream().collect(Collectors.toList());
        if (messagesOrigin.isEmpty())
            throw new MessagesNotFoundException("No hay mensajes para mostrar");
        return messagesOrigin;
    }

    @GetMapping("/messages/received/{usernameDestiny}")
    List <Message> getReceivedMessages(@PathVariable String usernameDestiny) {
        List <Message> messagesDestiny =
                messageRepository.findByUsernameDestiny(usernameDestiny).stream().collect(Collectors.toList());
        if (messagesDestiny.isEmpty())
            throw new MessagesNotFoundException("No hay mensajes para mostrar");
        return messagesDestiny;
    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message message){
        message.setSentDate(new Date());
        return messageRepository.save(message);
    }

    @GetMapping("/messages/all")
    List <Message> getAllMessages(){
        return messageRepository.findAll();
    }
}
