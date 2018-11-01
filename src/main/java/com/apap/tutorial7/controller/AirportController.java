package com.apap.tutorial7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.Setting;

/**
 * PilotController
 */
@RestController
@RequestMapping("/airport")
public class AirportController {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restAirport() {
		return new RestTemplate();
	}
	
	@GetMapping(value="/{city}")
	public String getAirport(@PathVariable("city") String city) throws Exception {
		String path = Setting.airportUrl + city + "&country=ID";
		return restTemplate.getForEntity(path, String.class).getBody();
	}
}