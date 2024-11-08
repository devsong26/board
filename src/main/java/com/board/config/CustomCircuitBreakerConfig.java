package com.board.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CustomCircuitBreakerConfig {

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry(){
        return CircuitBreakerRegistry.ofDefaults();
    }

    @Bean
    public CircuitBreaker membershipCircuitBreaker(CircuitBreakerRegistry circuitBreakerRegistry){
        final CircuitBreakerConfig membershipCircuitBreakerConfig =
                CircuitBreakerConfig.custom()
                        .slidingWindowSize(5)
                        .failureRateThreshold(50)
                        .waitDurationInOpenState(Duration.ofSeconds(30))
                        .ignoreExceptions(Exception.class)
                        .build();

        return circuitBreakerRegistry.circuitBreaker("membershipCircuitBreaker", membershipCircuitBreakerConfig);
    }

}
