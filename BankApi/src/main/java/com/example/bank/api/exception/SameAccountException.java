package com.example.bank.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class SameAccountException  extends RuntimeException{

    public SameAccountException(String message){
        super(message);
    }

}
