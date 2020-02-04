package com.capgemini.hotelsdbmgmtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelsDbMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsDbMgmtServiceApplication.class, args);
	}

}
