package com.newtech.employeeservice;

import com.newtech.employeeservice.mapper.MyMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	@Bean
	public MyMapper myMapper(){
		return Mappers.getMapper(MyMapper.class);
	}

}
