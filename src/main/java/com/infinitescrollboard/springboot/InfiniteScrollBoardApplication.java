package com.infinitescrollboard.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class InfiniteScrollBoardApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ScrollBoardApplication.class, args);
		new SpringApplicationBuilder(InfiniteScrollBoardApplication.class).properties("spring.config.location=" + "classpath:/application.properties" + ",classpath:/db.properties").run(args);
	}

}
