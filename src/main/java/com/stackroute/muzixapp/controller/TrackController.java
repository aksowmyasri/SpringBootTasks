package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.Exception.TrackAlreadyExistsException;
import com.stackroute.muzixapp.Exception.TrackNotFound;
import com.stackroute.muzixapp.model.Track;
import com.stackroute.muzixapp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Controller class containing crud handlers
@RestController
@RequestMapping(value="app/v1")
public class TrackController {

	@Autowired
	TrackService trackService;

	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}

	//add handler
	@PostMapping("track")
	public ResponseEntity<?> addTrack(@RequestBody Track track)throws TrackAlreadyExistsException
	{
		ResponseEntity responseEntity;

			trackService.saveTrack(track);
			responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
		return responseEntity;
	}

	//getting all tracks handler
	@GetMapping("track")
	public ResponseEntity<?> getAllTracks()
	{
		ResponseEntity responseEntity;

			responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);

		return responseEntity;
	}

	//delete handler
	@DeleteMapping("/track/{id}")
	public ResponseEntity<?> deleteTrack(@PathVariable(value="id") int trackId)throws TrackNotFound {
		ResponseEntity responseEntity;
			trackService.deleteTrack(trackId);
			responseEntity = new ResponseEntity("Deleted Successfully",HttpStatus.OK);


		return responseEntity;
	}

	@GetMapping("/track/{name}")
	public ResponseEntity<?> getTrackByName(@PathVariable(value = "name") String name)
	{
		ResponseEntity responseEntity;
		responseEntity = new ResponseEntity(trackService.getTrackByName(name),HttpStatus.OK);
		return responseEntity;

	}
	//update handler
	@PutMapping("/track/{id}")
	public ResponseEntity<?> updateTrack(@RequestParam(value="id")int trackId,@RequestBody Track trackDetails)throws TrackNotFound
	{
		ResponseEntity responseEntity;
			responseEntity = new ResponseEntity(trackService.updateTrack(trackId,trackDetails),HttpStatus.ACCEPTED);

		return responseEntity;
	}

}