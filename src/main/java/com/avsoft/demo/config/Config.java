package com.avsoft.demo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class Config {

	@Bean
	 Caffeine caffeineConfig() {
	    return Caffeine.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS)
	    		.maximumSize(100);
	}
	
	@Bean
	 CacheManager cacheManager(Caffeine caffeine) {
	    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
	    caffeineCacheManager.setCaffeine(caffeine);
	    return caffeineCacheManager;
	}
}
	
	

