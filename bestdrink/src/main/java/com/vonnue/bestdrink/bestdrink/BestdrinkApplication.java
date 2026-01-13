package com.vonnue.bestdrink.bestdrink;

import com.vonnue.bestdrink.bestdrink.model.Vote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BestdrinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestdrinkApplication.class, args);
    }

    @Bean
    public Vote globalVote() {
        return new Vote();
    }
}
