package com.example.springkpi.lab5.repositories;

import com.example.springkpi.lab5.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency findByCode(String code); // Автоматически найдет валюту по ее коду
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
