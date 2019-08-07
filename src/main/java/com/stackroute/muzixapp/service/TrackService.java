package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFound;
import com.stackroute.muzixapp.model.Track;

import java.util.List;
public interface TrackService {

    public Track saveTrack(Track track)throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();

    public Track updateTrack(int trackId,Track trackDetails)throws TrackNotFound;

    public void deleteTrack(int id)throws TrackNotFound;
}
