package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TrackExceptionController {
    @ExceptionHandler(value= TrackAlreadyExistsException.class)
    public ResponseEntity<Object> exception(TrackAlreadyExistsException exception)
    {
        return new ResponseEntity<>("Track already Exists", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= TrackNotFound.class)
    public ResponseEntity<Object> exception(TrackNotFound exception)
    {
        return new ResponseEntity<>("Track not found", HttpStatus.NOT_FOUND);
    }
}
