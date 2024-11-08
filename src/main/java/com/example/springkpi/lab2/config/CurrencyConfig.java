package com.example.springkpi.lab2.config;

import com.example.springkpi.lab2.models.Currency;
import com.example.springkpi.lab2.services.CurrencyService;
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
