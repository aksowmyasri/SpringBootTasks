package com.stackroute.muzixapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Exception if the track is not found

public class TrackNotFound extends RuntimeException{
}
