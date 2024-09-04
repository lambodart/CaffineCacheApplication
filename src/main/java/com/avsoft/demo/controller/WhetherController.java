package com.avsoft.demo.controller;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhetherController {

	@GetMapping("/getWhether/{city}")
	@Cacheable("mycache")
	public ResponseEntity getWhether(@PathVariable("city") String city) {
		
		TimeUnit seconds = TimeUnit.SECONDS;
		System.out.println(seconds);
		int ordinal = seconds.ordinal();
		System.out.println(ordinal);
		System.out.println("calling getWhether service :: " + LocalTime.now() + " City :: " +city); 

		return ResponseEntity.ok(city + " = 30");

	}
	
}
