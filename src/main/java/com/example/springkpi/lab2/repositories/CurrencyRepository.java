package com.example.springkpi.lab2.repositories;

import com.example.springkpi.lab2.models.Currency;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CurrencyRepository {
    private final Map<Long, Currency> currencies = new HashMap<>();

    public Currency save(Currency currency) {
        currencies.put(currency.getId(), currency);
        return currency;
    }

    public Currency findById(Long id) {
        return currencies.get(id);
    }

    public void delete(Long id) {
        currencies.remove(id);
    }

    public Map<Long, Currency> findAll() {
        return currencies;
    }
}
