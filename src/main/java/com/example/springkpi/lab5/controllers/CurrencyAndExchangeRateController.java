package com.example.springkpi.lab5.controllers;

import com.example.springkpi.lab5.dao.ExchangeRateDAO;
import com.example.springkpi.lab5.services.CurrencyService;
import com.example.springkpi.lab5.services.ExchangeRateService;
import com.example.springkpi.lab5.models.Currency;
import com.example.springkpi.lab5.models.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class CurrencyAndExchangeRateController {
    private final CurrencyService currencyService;
    private final ExchangeRateService exService;

    @Autowired
    public CurrencyAndExchangeRateController(CurrencyService currencyService, ExchangeRateService exService) {
        this.currencyService = currencyService;
        this.exService = exService;
    }

    // CRUD for Currency
    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    @GetMapping("currencies/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id) {
        Currency currency = currencyService.getCurrencyById(id);
        return currency != null ? ResponseEntity.ok(currency) : ResponseEntity.notFound().build();
    }

    @PostMapping("/currencies/add")
    public ResponseEntity<Currency> addCurrency(@RequestBody Currency currency) {

        if (currency.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        if (currency.getCode().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        //Currency createdCurrency = currencyService.createCurrency(currency);
        currencyService.createCurrency(currency);
        return ResponseEntity.status(HttpStatus.CREATED).body(currency);
    }

    @PutMapping("/currencies/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currency) {
        if (currency.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        if (currency.getCode().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        currency.setId(id);
        //Currency updateCurrency = currencyService.updateCurrency(currency);
        currencyService.updateCurrency(currency);
        //return currency != null ? ResponseEntity.ok(currency) : ResponseEntity.notFound().build();
        return ResponseEntity.ok(currency);
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
        Currency currency = currencyService.findCurrenciesByCode(currencyCode);

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
