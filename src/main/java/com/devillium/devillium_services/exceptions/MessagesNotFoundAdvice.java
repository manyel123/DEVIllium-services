package com.devillium.devillium_services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
@ResponseBody

public class MessagesNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MessagesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(MessagesNotFoundException ex){
        return ex.getMessage();
    }

}
