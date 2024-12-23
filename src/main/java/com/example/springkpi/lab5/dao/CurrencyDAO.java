package com.example.springkpi.lab5.dao;

import com.example.springkpi.lab5.models.Currency;

import java.util.List;

public interface CurrencyDAO {
    Long create(Currency currency);
    Currency read(Long id);
    void update(Currency currency);
    void delete(Long id);
    Currency findByCode(String code);
    List<Currency> findAll();
}

//@Repository
//public class CurrencyRepository {
//    private final Map<Long, Currency> currencies = new HashMap<>();
//
//    public Currency save(Currency currency) {
//        currencies.put(currency.getId(), currency);
//        return currency;
//    }
//
//    public Currency findById(Long id) {
//        return currencies.get(id);
//    }
//
//    public Currency findByCode(String code) {
//        for(Currency currency : currencies.values()) {
//            if(currency.getCode().equals(code)) {
//                return currency;
//            }
//        }
//        throw new IllegalArgumentException();
//    }
//
//    public void delete(Long id) {
//        currencies.remove(id);
//    }
//
//    public Map<Long, Currency> findAll() {
//        return currencies;
//    }
//}
