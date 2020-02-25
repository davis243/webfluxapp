package com.davis.webfluxapp;

import com.davis.webfluxapp.model.Gadget;
import com.davis.webfluxapp.repository.GadgetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;

@SpringBootApplication
//@EnableWebFlux
public class WebfluxappApplication {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(WebfluxappApplication.class, args);
	}

	@Bean
	CommandLineRunner start(GadgetRepository gadgetRepository) {
		gadgetRepository.deleteAll();
		return args -> {

			Flux.just(
					new Gadget("1", "smartphone "),
					new Gadget("2", "smartwatch"),
					new Gadget("3", "wireless charger"),
					new Gadget("4", "headphones"))
					.flatMap(gadgetRepository::save)
					.subscribe(gadget -> log.info("gadget: {}", gadget));

		};
	}
}
