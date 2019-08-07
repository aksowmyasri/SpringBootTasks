package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFound;
import com.stackroute.muzixapp.model.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    //method to add track
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
       if(trackRepository.existsById(track.getId()))
       {
           throw new TrackAlreadyExistsException("track already exists");
       }

        Track savedTrack = trackRepository.save(track);
       if(savedTrack == null)
       {
           throw new TrackAlreadyExistsException("track already exists");
       }
        return savedTrack;
    }

    //method to get all the tracks
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }


    //method to update track
    @Override
    public Track updateTrack(int trackId,Track trackDetails)throws TrackNotFound {
        Track updatedTrack = trackRepository.findById(trackId).orElseThrow(()->new TrackNotFound("track not found"));
        updatedTrack.setName(trackDetails.getName());
        updatedTrack.setComment(trackDetails.getComment());
        trackRepository.save(updatedTrack);
        return updatedTrack;
    }

    //method to delete track
    @Override
    public void deleteTrack(int id)throws TrackNotFound {
        if(!trackRepository.findById(id).isPresent()) {
            throw new TrackNotFound("Track Not Found");
        }
        trackRepository.deleteById(id);
    }
}
