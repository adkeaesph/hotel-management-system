package com.capgemini.hoteldbmgmtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelDbMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelDbMgmtServiceApplication.class, args);
	}

}
