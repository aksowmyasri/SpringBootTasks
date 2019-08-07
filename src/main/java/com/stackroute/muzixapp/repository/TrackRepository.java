package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//Class containing crud operations
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

    @Query("select t from Track t where t.name = ?1")
     Track findByName(@Param("name") String name);
}
