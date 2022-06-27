package com.devillium.devillium_services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
@ResponseBody

public class ContactFormNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ContactFormNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(ContactFormNotFoundException ex){
        return ex.getMessage();
    }

}
