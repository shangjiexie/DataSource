package com.sjxie.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class resourceServerMain {
	public static void main(String[] args) {
		SpringApplication.run(resourceServerMain.class, args);
	}
}
