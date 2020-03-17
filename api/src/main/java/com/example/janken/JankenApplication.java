package com.example.janken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rps.Rps;

@SpringBootApplication
public class JankenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JankenApplication.class, args);
	}

	@Bean
	Rps createRps() {
		return new Rps();
	}

	@Bean
	public WebMvcConfigurer createWebMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}
}
