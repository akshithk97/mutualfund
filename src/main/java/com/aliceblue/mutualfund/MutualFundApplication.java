package com.aliceblue.mutualfund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MutualFundApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MutualFundApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MutualFundApplication.class);
	}
}
