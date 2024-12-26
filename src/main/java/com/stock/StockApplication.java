package com.stock;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stock.Services.HashCodePassword;

@SpringBootApplication
@EntityScan("com.stock.Entities")
@ComponentScan("com.stock")
@EnableJpaRepositories("com.stock.Repositories")
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public HashCodePassword passwordEncoder()
	{
		return new HashCodePassword();
	}
}
