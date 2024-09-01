package com.codewithsam.unboxingPostgres;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnboxingPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnboxingPostgresApplication.class, args);
		System.out.println("Runnning");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
