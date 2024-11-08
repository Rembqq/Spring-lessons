package com.example.springkpi.lab2.controllers;

import com.example.springkpi.lab2.models.Currency;
import com.example.springkpi.lab2.models.ExchangeRate;
import com.example.springkpi.lab2.services.CurrencyService;
import com.example.springkpi.lab2.services.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CurrencyAndExchangeRateController {
    CurrencyService service;
    private final ExchangeRateService exService;

    public CurrencyAndExchangeRateController(ExchangeRateService exService) {
        this.exService = exService;
    }
    //    public CurrencyController(CurrencyService service) {
//        this.service = service;
//    }
    @Autowired
    public void setService(CurrencyService service) {
        this.service = service;
    }

    @GetMapping("/currencies")
    public String listCurrencies(Model model) {
        //System.out.println(service.getAllCurrencies());

        model.addAttribute("currencies", service.getAllCurrencies().values());
        return "currencies";
    }

    @GetMapping("/currencies/add")
    public String addCurrencyForm(Model model) {
        model.addAttribute("currency", new Currency());
        return "currencies";
    }

    @PostMapping("/currencies/add")
    public String addCurrency(@ModelAttribute Currency currency, @RequestParam String role) {
        System.out.println(currency);
        if("admin".equalsIgnoreCase(role)) {
            service.addCurrency(currency);
        }
        return "redirect:/currencies";
    }

    @GetMapping("/currencies/edit/{id}")
    public String editCurrencyForm(@PathVariable Long id, Model model, @RequestParam String role) {
        if ("admin".equalsIgnoreCase(role)) {
            Currency currency = service.getCurrencyById(id);
            model.addAttribute("currency", currency);
            return "editCurrency";
        }
        return "redirect:/currencies";
    }
    @PostMapping("/currencies/edit/{id}")
    public String editCurrency(@PathVariable Long id, @ModelAttribute Currency currency, @RequestParam String role) {
        if ("admin".equalsIgnoreCase(role)) {
            currency.setId(id);
            service.updateCurrency(currency);
        }
        return "redirect:/currencies";
    }

    @PostMapping("/currencies/delete/{id}")
    public String deleteCurrency(@PathVariable Long id, @RequestParam String role) {
        if("admin".equalsIgnoreCase(role)) {
            service.deleteCurrency(id);
        }
        return "redirect:/currencies";
    }

    @GetMapping("/rates")
    public String getRatesForToday(Model model) {
        model.addAttribute("rates", exService.getExchangeRatesForDate(LocalDate.now()));
        return "rates";
    }

    @GetMapping("/rates/currency")
    public String getRatesByCurrencyAndDateRange(
            @RequestParam String code,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            Model model) {
        List<ExchangeRate> rates = exService.getExchangeRatesByCurrencyAndDateRange(code, startDate, endDate);
        model.addAttribute("rates", rates);
        return "rates";
    }

    @GetMapping("/rates/addByDayAndCode")
    public String addExCurrencyForm(Model model) {
        model.addAttribute("exchangeRate", new ExchangeRate());
        return "rates";
    }

    @PostMapping("/rates/addByDayAndCode")
    public String addByDayAndCode(@ModelAttribute ExchangeRate exchangeRate, @RequestParam String currencyCode,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                   @RequestParam String role) {
        Currency currency = null;
        if ("admin".equalsIgnoreCase(role)) {
            currency = service.getCurrencyByCode(currencyCode);
            System.out.println("Currency: " + currency);
            System.out.println("Ex Rate: " + exchangeRate);
            if(currency != null) {
                exchangeRate.setCurrency(currency);
                exchangeRate.setDate(date);
                exService.addByDateAndCode(exchangeRate);
            }
        }
        System.out.println(exchangeRate);

        assert currency != null;
        return "redirect:/rates/currency?role=admin&code=" + currency.getCode() +
                "&startDate=" + exchangeRate.getDate() + "&endDate=" + exchangeRate.getDate();
    }
}
