package com.example.springkpi.lab2.services;

import com.example.springkpi.lab2.models.Currency;
import com.example.springkpi.lab2.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CurrencyService {
    public final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

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

    public void deleteCurrency(Long id) {
        currencyRepository.delete(id);
    }


//    public void getAllExchangeRatesToday() {
//
//    }
//    public void getCertainExchangeRateCertainTime(LocalDate startDate, LocalDate endDate) {
//
//    }

}
