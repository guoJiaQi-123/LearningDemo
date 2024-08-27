package com.tyut;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TranscriptionApplication {

	public static void main(String[] args) {

		SpringApplication.run(TranscriptionApplication.class, args);
		log.info("******************* SUCCESS *******************");
	}

}
