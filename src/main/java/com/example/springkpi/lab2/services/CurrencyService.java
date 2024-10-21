package com.example.springkpi.lab2.services;

import com.example.springkpi.lab2.models.Date;
import com.example.springkpi.lab2.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    public final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    public void getAllExchangeRatesToday() {

    }
    public void getCertainExchangeRateCertainTime(Date date) {

    }

}
