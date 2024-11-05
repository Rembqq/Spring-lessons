package com.example.springkpi.lab2.controllers;

import com.example.springkpi.lab2.models.ExchangeRate;
import com.example.springkpi.lab2.services.ExchangeRateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/rates")
public class ExchangeRateController {
    private final ExchangeRateService service;

    public ExchangeRateController(ExchangeRateService service) {
        this.service = service;
    }

    @GetMapping
    public String getRatesForToday(Model model) {
        model.addAttribute("rates", service.getExchangeRatesForDate(LocalDate.now()));
        return "rates";
    }

    @GetMapping("/currency")
    public String getRatesByCurrencyAndDateRange(
            @RequestParam String currencyCode, @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate, Model model) {
        List<ExchangeRate> rates = service.getExchangeRatesByCurrencyAndDateRange(currencyCode, startDate, endDate);
        model.addAttribute("rates", rates);
        return "rates";

    }

    @GetMapping("/addRate")
    public String addRateForm(Model model) {
        model.addAttribute("rate", new ExchangeRate());
        return "addRate";
    }

    @PostMapping("/addRate")
    public String addRate(@ModelAttribute ExchangeRate rate, @RequestParam String role) {
        if("admin".equalsIgnoreCase(role)) {
            service.addExchangeRate(rate);
        }
        return "redirect:/rates";
    }

}
