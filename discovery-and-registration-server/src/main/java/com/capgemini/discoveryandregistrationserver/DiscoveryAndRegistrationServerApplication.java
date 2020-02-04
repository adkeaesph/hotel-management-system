package com.capgemini.discoveryandregistrationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryAndRegistrationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryAndRegistrationServerApplication.class, args);
	}

}
