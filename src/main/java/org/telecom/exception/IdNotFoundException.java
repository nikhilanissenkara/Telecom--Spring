package org.telecom.exception;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

public class IdNotFoundException extends Exception{
    public IdNotFoundException(String message){
        super(message);
    }

}
