package com.example.springkpi.lab5.services.impl;

import com.example.springkpi.lab5.models.Currency;
import com.example.springkpi.lab5.dao.CurrencyDAO;
import com.example.springkpi.lab5.services.CurrencyService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyDAO currencyDAO;

    public CurrencyServiceImpl(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Transactional
    @Override
    public Long createCurrency(Currency currency) {
        return currencyDAO.create(currency);
        //currencyDAO.create(currency);
    }

    @Override
    public Currency getCurrencyById(Long id) {
        return currencyDAO.read(id);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyDAO.findAll();
    }

    @Transactional
    @Override
    public void updateCurrency(Currency currency) {
        currencyDAO.update(currency);
    }

    @Transactional
    @Override
    public void deleteCurrency(Long id) {
        currencyDAO.delete(id);
    }

    @Override
    public Currency findCurrenciesByCode(String code) {
        return currencyDAO.findByCode(code);
    }
}
