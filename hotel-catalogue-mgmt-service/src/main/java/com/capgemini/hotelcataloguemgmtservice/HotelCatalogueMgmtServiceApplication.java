package com.capgemini.hotelcataloguemgmtservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelCatalogueMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelCatalogueMgmtServiceApplication.class, args);
	}

}
