package edu.bearcat.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"edu.bearcat.microservice"})
@ComponentScan("edu.bearcat.microservice")
public class ClientFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientFeignApplication.class, args);
	}

}
