package com.stackroute.muzixapp.Exception;
//EXception class if the track already exists
public class TrackAlreadyExistsException extends Exception{
    private String message;

    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
