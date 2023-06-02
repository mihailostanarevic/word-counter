package com.synechron.wordcounterservice.config;

import com.synechron.wordcounter.counter.Counter;
import com.synechron.wordcounter.counter.CounterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Counter counter() {
        return new CounterImpl();
    }
}
