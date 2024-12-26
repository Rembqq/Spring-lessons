package com.example.springkpi.lab6.services;

import com.example.springkpi.lab6.models.ExchangeRate;
import com.example.springkpi.lab6.repositories.ExchangeRateRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public List<ExchangeRate> getExchangeRatesForDate(LocalDate date) {
        return exchangeRateRepository.findByDate(date);
    }

    public List<ExchangeRate> getExchangeRatesByCurrencyAndDateRange(String code, LocalDate start, LocalDate end) {
        return exchangeRateRepository.findByCurrencyAndDateRange(code, start, end);
    }

    public ExchangeRate addByDateAndCode(ExchangeRate rate) {
        return exchangeRateRepository.save(rate); // Сохраняем курс обмена
    }

    public Long createExchangeRate(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate).getId();
    }

    public void updateExchangeRate(ExchangeRate exchangeRate) {
        exchangeRateRepository.save(exchangeRate);
    }

    public void deleteExchangeRate(Long id) {
        exchangeRateRepository.deleteById(id);
    }

    public ExchangeRate getExchangeRateById(Long id) {
        return exchangeRateRepository.findById(id).orElse(null);
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
