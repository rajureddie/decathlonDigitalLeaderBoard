package com.example.DecathlonDigitalOrders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DecathlonDigitalOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecathlonDigitalOrdersApplication.class, args);
	}

}
