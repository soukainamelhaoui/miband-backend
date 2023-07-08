package com.iotconnect.miband;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MibandbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MibandbackendApplication.class, args);
	}

}
