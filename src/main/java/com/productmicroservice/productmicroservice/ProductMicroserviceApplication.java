package com.productmicroservice.productmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMicroserviceApplication.class, args);
	}

	@Configuration
	@EnableJpaRepositories(basePackages = "com.productmicroservice.productmicroservice.Repository")
	@EntityScan(basePackages = "com.productmicroservice.productmicroservice.Model")
	public class JpaConfig {

	}

}
