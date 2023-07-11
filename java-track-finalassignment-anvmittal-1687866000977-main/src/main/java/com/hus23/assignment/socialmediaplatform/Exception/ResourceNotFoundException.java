package com.hus23.assignment.socialmediaplatform.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String Message){
        super(Message);
    }

    public ResourceNotFoundException(String Message, Throwable throwable){
        super(Message, throwable);
    }

}
