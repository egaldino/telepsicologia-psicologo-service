package br.puc.edson.telepsicologiapsicologoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class TelepsicologiaPsicologoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelepsicologiaPsicologoServiceApplication.class, args);
	}

}
