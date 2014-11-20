package com.cp.scheduler.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.cp"})
@EnableAutoConfiguration
public class MainImpl {

	public static void main(String[] args) {
		SpringApplication.run(MainImpl.class, args);

	}

}
