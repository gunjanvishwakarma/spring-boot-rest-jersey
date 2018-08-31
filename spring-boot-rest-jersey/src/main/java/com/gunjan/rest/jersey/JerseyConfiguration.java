package com.gunjan.rest.jersey;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.gunjan.rest.jersey.controller.BookController;

@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(BookController.class);
		register(GenericExceptionMapper.class);
	}
}
