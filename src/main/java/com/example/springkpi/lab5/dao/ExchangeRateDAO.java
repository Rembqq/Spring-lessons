package com.example.springkpi.lab5.dao;

import com.example.springkpi.lab5.models.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateDAO {
    Long create(ExchangeRate exchangeRate);
    ExchangeRate read(Long id);
    void update(ExchangeRate exchangeRate);
    void deleteById(Long id);
    List<ExchangeRate> findByDate(LocalDate date);
    List<ExchangeRate> findByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate);
}
