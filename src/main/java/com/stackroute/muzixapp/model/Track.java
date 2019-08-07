package com.stackroute.muzixapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Entity;
import javax.persistence.Id;
//Springboot entity
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Configuration
public class Track {

	@Id
	private int id;
	private String name;

	private String comment;




}