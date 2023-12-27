package com.example.springcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
@ResponseBody

public class usernotfoundadvice {
    @ExceptionHandler(usernotfound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
        Map<String,String>exceptionhandler(usernotfound exception)
        {
           Map<String,String> errormap=new HashMap<>();
           errormap.put("error",exception.getMessage());
           return errormap;
        }
    }

