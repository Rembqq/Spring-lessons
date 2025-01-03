package com.example.springkpi.lab4.services;

import com.example.springkpi.lab4.models.Currency;
import com.example.springkpi.lab4.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public Currency addCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    public Currency updateCurrency(Currency currency) {
        Currency existing = currencyRepository.findById(currency.getId());

        if(existing != null) {
            existing.setName(currency.getName());
            return currencyRepository.save(existing);
        }
        return null;
    }

    public Currency getCurrencyById(Long id) {
        return currencyRepository.findById(id);
    }

    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findByCode(code);
    }

    public void deleteCurrency(Long id) {
        currencyRepository.delete(id);
    }

    public Map<Long, Currency> getAllCurrencies() { return currencyRepository.findAll(); }

}
