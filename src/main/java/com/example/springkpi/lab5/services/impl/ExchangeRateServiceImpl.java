package com.example.springkpi.lab5.services.impl;

import com.example.springkpi.lab5.dao.ExchangeRateDAO;
import com.example.springkpi.lab5.models.Currency;
import com.example.springkpi.lab5.models.ExchangeRate;
import com.example.springkpi.lab5.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateDAO exchangeRateDAO;

    public ExchangeRateServiceImpl(ExchangeRateDAO exchangeRateDAO) {
        this.exchangeRateDAO = exchangeRateDAO;
    }

    @Override
    public List<ExchangeRate> getExchangeRatesForDate(LocalDate date) {
        return exchangeRateDAO.findByDate(date);
    }

    @Override
    public List<ExchangeRate> getExchangeRatesByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate) {
        if (startDate == null) {
            startDate = LocalDate.MIN;
        }
        if (endDate == null) {
            endDate = LocalDate.now();
        }
        return exchangeRateDAO.findByCurrencyAndDateRange(currencyCode, startDate, endDate);
    }

    @Override
    public void addByDateAndCode(ExchangeRate exchangeRate) {
        exchangeRateDAO.create(exchangeRate);
    }

    @Override
    public void deleteExchangeRate(Long id) {
        exchangeRateDAO.deleteById(id);
    }

    @Override
    public ExchangeRate getExchangeRateById(Long id) {
        return exchangeRateDAO.read(id);
    }

    @Override
    public ExchangeRate updateExchangeRate(Long id, BigDecimal rate) {
        ExchangeRate exchangeRate = getExchangeRateById(id);
        if (exchangeRate != null) {
            exchangeRate.setRate(rate);
            exchangeRateDAO.update(exchangeRate);
            return exchangeRate;
        }
        return null;
    }
}
