package com.example.springkpi.lab3.repositories;

import com.example.springkpi.lab3.models.ExchangeRate;
import org.springframework.stereotype.Repository;

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
