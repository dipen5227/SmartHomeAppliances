package com.applicances.Appliance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@EnableScheduling
public class SmartHomeAppliancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartHomeAppliancesApplication.class, args);
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title("Smart Home Appliances Application").description("Appliance control solution"));
	}
}
