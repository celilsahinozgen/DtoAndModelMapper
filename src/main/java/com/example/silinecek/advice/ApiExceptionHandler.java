package com.example.silinecek.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalAccessException.class)
    public final ResponseEntity<ExcepitonResponse> illagelException(Exception exception, WebRequest request){

            ExcepitonResponse excepitonResponse = new ExcepitonResponse(LocalDateTime.now(), "1000", exception.getMessage());
            return new ResponseEntity<ExcepitonResponse>(excepitonResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ExcepitonResponse> userNotFound (Exception exception, WebRequest request) {

            ExcepitonResponse excepitonResponse = new ExcepitonResponse(LocalDateTime.now(),"2000", exception.getMessage());
            return new ResponseEntity<ExcepitonResponse>(excepitonResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepitonResponse> exception (Exception exception, WebRequest request) {

        ExcepitonResponse excepitonResponse = new ExcepitonResponse(LocalDateTime.now(),"5000", exception.getMessage());
        return new ResponseEntity<ExcepitonResponse>(excepitonResponse,HttpStatus.EXPECTATION_FAILED);

    }


}
