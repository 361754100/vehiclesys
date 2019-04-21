package com.hro.core.vehiclesys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hro.core.vehiclesys.dao.mapper")
public class VehiclesysApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesysApplication.class, args);
	}

}
