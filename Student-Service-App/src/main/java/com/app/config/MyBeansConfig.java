package com.app.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyBeansConfig {
	
	@Value("${addressservice.base.url}")
	String addressBaseUrl;

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	WebClient webClient() {
		return WebClient.builder().baseUrl(addressBaseUrl).build();
	}

}
