package com.example.issuemanagement.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class IMExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request){
        ExcetionResponse excetionResponse=new ExcetionResponse(new Date(),ex.getMessage());

        return new ResponseEntity<>(excetionResponse, HttpStatus.EXPECTATION_FAILED);
    }
}
