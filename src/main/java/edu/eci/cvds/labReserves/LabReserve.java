package edu.eci.cvds.labReserves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The LabReserve class serves as the entry point for the Spring Boot application.
 * It triggers the application startup by invoking the SpringApplication.run() method.
 */
@SpringBootApplication
public class LabReserve {

	/**
	 * The main method is the entry point of the Java application.
	 * It initializes the Spring Boot application context and starts the application.
	 *
	 * @param args command-line arguments passed during application startup.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LabReserve.class, args);
	}

}
