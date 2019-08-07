package com.stackroute.muzixapp.Exception;
//Exception if the track is not found
public class TrackNotFound extends Exception{
    private String message;

    public TrackNotFound(String message) {
        super(message);
        this.message = message;
    }
}
