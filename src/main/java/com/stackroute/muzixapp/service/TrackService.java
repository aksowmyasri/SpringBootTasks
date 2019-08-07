package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFound;
import com.stackroute.muzixapp.model.Track;

import java.util.List;
public interface TrackService {

    Track saveTrack(Track track)throws TrackAlreadyExistsException;
    List<Track> getAllTracks();
     Track getTrackByName(String name);
   Track updateTrack(int trackId,Track trackDetails)throws TrackNotFound;

    void deleteTrack(int id)throws TrackNotFound;
}
