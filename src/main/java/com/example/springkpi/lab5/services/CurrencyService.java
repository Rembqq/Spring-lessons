package com.example.springkpi.lab5.services;

import com.example.springkpi.lab5.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CurrencyService {
    List<Currency> getAllCurrencies();
    Long createCurrency(Currency currency);
    Currency getCurrencyById(Long id);
    void updateCurrency(Currency currency);
    void deleteCurrency(Long id);
    Currency findCurrenciesByCode(String code);
}

//@Service
//public class CurrencyService {
//
//    @Autowired
//    private CurrencyRepository currencyRepository;
//
//    public Currency addCurrency(Currency currency) {
//        return currencyRepository.save(currency);
//    }
//
//    public Currency updateCurrency(Currency currency) {
//        return currencyRepository.findById(currency.getId())
//                .map(existing -> {
//                    existing.setName(currency.getName());
//                    return currencyRepository.save(existing);
//                })
//                .orElse(null);
//    }
//
//    public Currency getCurrencyById(Long id) {
//        return currencyRepository.findById(id).orElse(null);
//    }
//
//    public Currency getCurrencyByCode(String code) {
//        return currencyRepository.findByCode(code);
//    }
//
//    public void deleteCurrency(Long id) {
//        currencyRepository.deleteById(id);
//    }
//
//    public List<Currency> getAllCurrencies() {
//        return currencyRepository.findAll();
//    }
//}


//@Service
//public class CurrencyService {
//
//    @Autowired
//    private CurrencyRepository currencyRepository;
//
//    public Currency addCurrency(Currency currency) {
//        return currencyRepository.save(currency);
//    }
//
//    public Currency updateCurrency(Currency currency) {
//        Currency existing = currencyRepository.findById(currency.getId());
//
//        if(existing != null) {
//            existing.setName(currency.getName());
//            return currencyRepository.save(existing);
//        }
//        return null;
//    }
//
//    public Currency getCurrencyById(Long id) {
//        return currencyRepository.findById(id);
//    }
//
//    public Currency getCurrencyByCode(String code) {
//        return currencyRepository.findByCode(code);
//    }
//
//    public void deleteCurrency(Long id) {
//        currencyRepository.delete(id);
//    }
//
//    public Map<Long, Currency> getAllCurrencies() { return currencyRepository.findAll(); }
//
//}
