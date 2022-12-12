package com.trungtamjava.master.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HellospringApplication {
	@Bean
	public Laptop laptop1() {
		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setName("Thuan");
		return laptop;
	}

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}
}
// spring container
// bean: object: IoC
// DI (Dependenc Inject) : dung lai bean

