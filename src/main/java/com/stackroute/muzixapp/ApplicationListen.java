package com.stackroute.muzixapp;

import com.stackroute.muzixapp.model.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ApplicationListen implements ApplicationListener<ContextRefreshedEvent> {
    ;
    @Autowired
    TrackService trackService;

    public ApplicationListen(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //Track track = new Track(2, "lalala", "from kabir singh");
       // try {
         //   trackService.saveTrack(track);
           // for (Track track1 : trackService.getAllTracks()) {
             //   System.out.println(trackService.getAllTracks());
            //}
        //} catch (Exception e) {
          //  e.printStackTrace();
        //}
    }
}
