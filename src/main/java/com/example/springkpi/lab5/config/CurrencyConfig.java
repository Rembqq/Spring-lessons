package com.example.springkpi.lab5.config;

import com.example.springkpi.lab4.services.CurrencyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CurrencyConfig {

    @Bean
    @Scope("singleton")
    public CurrencyService currencyService() {
        return new CurrencyService();
    }

}
