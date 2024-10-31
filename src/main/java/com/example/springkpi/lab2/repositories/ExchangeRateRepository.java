package com.example.springkpi.lab2.repositories;

import com.example.springkpi.lab2.models.Currency;
import com.example.springkpi.lab2.models.ExchangeRate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExchangeRateRepository {
    private final List<ExchangeRate> rates = new ArrayList<>();

    public ExchangeRate save(ExchangeRate rate) {
        rates.add(rate);
        return rate;
    }

    public List<ExchangeRate> findByDate(LocalDate date) {
        List<ExchangeRate> result = new ArrayList<>();

        for(ExchangeRate rate : rates) {
            if(rate.getDate().equals(date)) {
                result.add(rate);
            }
        }
        return result;
    }

    public List<ExchangeRate> findByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate) {
        List<ExchangeRate> result = new ArrayList<>();
        for(ExchangeRate rate : rates) {
            if(rate.getCurrency().getCode().equalsIgnoreCase(currencyCode) &&
                    (rate.getDate().isEqual(startDate) || rate.getDate().isAfter(startDate)) &&
                    (rate.getDate().isEqual(endDate) || rate.getDate().isBefore(endDate))) {
                result.add(rate);
            }
        }
        return result;
    }

}
