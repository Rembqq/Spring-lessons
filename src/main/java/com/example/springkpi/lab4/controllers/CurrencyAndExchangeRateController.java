package com.example.springkpi.lab4.controllers;

import com.example.springkpi.lab4.CurrencyRateMain;
import com.example.springkpi.lab4.models.Currency;
import com.example.springkpi.lab4.models.ExchangeRate;
import com.example.springkpi.lab4.services.CurrencyService;
import com.example.springkpi.lab4.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class CurrencyAndExchangeRateController {
    CurrencyService currencyService;
    private final ExchangeRateService exService;

    public CurrencyAndExchangeRateController(ExchangeRateService exService) {
        this.exService = exService;
    }

    @Autowired
    public void setService(CurrencyService service) {
        this.currencyService = service;
    }

    // CRUD for Currency
    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        return ResponseEntity.ok(List.copyOf(currencyService.getAllCurrencies().values()));
    }

    @GetMapping("currencies/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id) {
        Currency currency = currencyService.getCurrencyById(id);
        return currency != null ? ResponseEntity.ok(currency) : ResponseEntity.notFound().build();
    }

    @PostMapping("/currencies/add")
    public ResponseEntity<Currency> addCurrency(@RequestBody Currency currency) {
        Currency createdCurrency = currencyService.addCurrency(currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCurrency);
    }

    @PutMapping("/currencies/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currency) {
        currency.setId(id);
        Currency updateCurrency = currencyService.updateCurrency(currency);
        return updateCurrency != null ? ResponseEntity.ok(updateCurrency) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/currencies/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        currencyService.deleteCurrency(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rates")
    public ResponseEntity<List<ExchangeRate>> getRatesForToday() {
        List<ExchangeRate> rates = exService.getExchangeRatesForDate(LocalDate.now());
        return ResponseEntity.ok(rates);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeRate>> getRates(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        List<ExchangeRate> rates = exService.getExchangeRatesByCurrencyAndDateRange(code, startDate, endDate);
        return ResponseEntity.ok(rates);
    }

    @GetMapping("/rates/currency")
    public ResponseEntity<List<ExchangeRate>> getRatesByCurrencyAndDateRange(
            @RequestParam String code,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
            ) {
        List<ExchangeRate> rates = exService.getExchangeRatesByCurrencyAndDateRange(code, startDate, endDate);

        if (rates.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(rates);
    }

    @PostMapping("/rates/addByDayAndCode")
    public ResponseEntity<ExchangeRate> addByDayAndCode(
            @RequestParam BigDecimal rate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String currencyCode
//            @RequestBody BigDecimal rate,
//            //@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
//            @RequestBody String currencyCode
    ) {
        Currency currency = currencyService.getCurrencyByCode(currencyCode);

        if (currency == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

//        if (exchangeRate == null
//            || currencyService.getCurrencyByCode(exchangeRate.getCurrency().getCode()) == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(null);
//        }


        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrency(currency);
        exchangeRate.setRate(rate);
        exchangeRate.setDate(date);
        exService.addByDateAndCode(exchangeRate);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(exchangeRate);
    }
}
