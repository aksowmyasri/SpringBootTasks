package com.stackroute.muzixapp;

import com.stackroute.muzixapp.model.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TrackCommandLineListener implements CommandLineRunner {
    @Autowired
    TrackService trackService;
    @Override
    public void run(String... args) throws Exception {
    Logger logger = LoggerFactory.getLogger(TrackCommandLineListener.class);
    try
    {
        Track track = new Track(1,"bekhayali","grom kabir singh");
        trackService.saveTrack(track);
        for(Track track1:trackService.getAllTracks())
        {
            logger.info(track1.toString());
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    }
}
