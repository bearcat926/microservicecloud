package edu.bearcat.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient       //本服务启动后会自动注册进Eureka
@EnableDiscoveryClient    //服务发现
public class ModelRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModelRestaurantApplication.class, args);
	}

}
