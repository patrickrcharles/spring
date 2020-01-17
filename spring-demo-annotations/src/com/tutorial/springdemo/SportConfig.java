package com.tutorial.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.tutorial.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define sad fortune service
	@Bean
	public FortuneService SadFortuneService() {
		return new SadFortuneService();
	}

	//define bean for swim coach and inject
	@Bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(SadFortuneService()); //inject fortune by calling fortune constructor
		return mySwimCoach;
	}
}
