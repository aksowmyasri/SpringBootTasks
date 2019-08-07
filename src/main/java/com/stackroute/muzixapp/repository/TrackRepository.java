package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Class containing crud operations
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
}
