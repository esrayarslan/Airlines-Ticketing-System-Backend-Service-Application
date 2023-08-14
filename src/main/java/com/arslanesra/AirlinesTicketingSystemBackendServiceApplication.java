package com.arslanesra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AirlinesTicketingSystemBackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinesTicketingSystemBackendServiceApplication.class, args);
	}

}
