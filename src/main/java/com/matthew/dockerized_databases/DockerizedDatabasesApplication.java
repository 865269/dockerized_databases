package com.matthew.dockerized_databases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DockerizedDatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerizedDatabasesApplication.class, args);
	}

}
