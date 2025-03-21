package com.test.book.online_mobile_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OnlineMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMobileApplication.class,args);
	}

}
