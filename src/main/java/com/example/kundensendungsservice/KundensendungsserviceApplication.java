package com.example.kundensendungsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KundensendungsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KundensendungsserviceApplication.class, args);
	}

}
