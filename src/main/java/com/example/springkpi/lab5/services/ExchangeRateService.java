package com.example.springkpi.lab5.services;

import com.example.springkpi.lab5.models.ExchangeRate;
import com.example.springkpi.lab5.repositories.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangeRateService {

    private final ExchangeRateRepository repository;

    public ExchangeRateService(ExchangeRateRepository repository) {
        this.repository = repository;
    }

    public ExchangeRate addByDateAndCode(ExchangeRate rate) {
        return repository.save(rate);
    }

    public List<ExchangeRate> getExchangeRatesForDate(LocalDate date) {
        return repository.findByDate(date);
    }

    public List<ExchangeRate> getExchangeRatesByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate) {
        return repository.findByCurrencyAndDateRange(currencyCode, startDate, endDate);
    }
}

//@Service
//public class ExchangeRateService {
//
//    private final ExchangeRateRepository repository;
//
//    public ExchangeRateService(ExchangeRateRepository repository) {
//        this.repository = repository;
//    }
//
//    public ExchangeRate addByDateAndCode(ExchangeRate rate) {
//        return repository.save(rate);
//    }
//
//    public List<ExchangeRate> getExchangeRatesForDate(LocalDate date) {
//        return repository.findByDate(date);
//    }
//
//    public List<ExchangeRate> getExchangeRatesByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate) {
//        return repository.findByCurrencyAndDateRange(currencyCode, startDate, endDate);
//    }
//
//}
