package com.stackroute.muzixapp;

import com.stackroute.muzixapp.model.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class TrackCommandLineListener implements CommandLineRunner {
    @Autowired
    TrackService trackService;
    @Value("${track.id}")
    private int id;
    @Value("${track.name}")
    private String name;
    @Value("${track.comment}")
    private String comment;

    @Autowired
    private Environment environment;
    @Override
    public void run(String... args) throws Exception {
    Logger logger = LoggerFactory.getLogger(TrackCommandLineListener.class);
    try
    {
        Track track = new Track(id,name,comment);
        trackService.saveTrack(track);
        for(Track track1:trackService.getAllTracks())
        {
            logger.info(track1.toString());
        }
        System.out.println(environment.getProperty("server.port"));
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    }
}
