package com.example.springkpi.lab5.services;

import com.example.springkpi.lab5.models.ExchangeRate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateService {
    List<ExchangeRate> getExchangeRatesForDate(LocalDate date);

    List<ExchangeRate> getExchangeRatesByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate);

    void addByDateAndCode(ExchangeRate exchangeRate);

    void deleteExchangeRate(Long id);

    ExchangeRate getExchangeRateById(Long id);

    ExchangeRate updateExchangeRate(Long id, BigDecimal rate);
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
//        return repository.  findByDate(date);
//    }
//
//    public List<ExchangeRate> getExchangeRatesByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate) {
//        return repository.findByCurrencyAndDateRange(currencyCode, startDate, endDate);
//    }
//}

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
