package com.tunisair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories(basePackages="com.tunisair")
public class TunisairApplication {

	public static void main(String[] args) {
		SpringApplication.run(TunisairApplication.class, args);
	}

}
