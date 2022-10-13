package com.example.fse.eureka.eStockEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EStockEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EStockEurekaApplication.class, args);
	}

}
