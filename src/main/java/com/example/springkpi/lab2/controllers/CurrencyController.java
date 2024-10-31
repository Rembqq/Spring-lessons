package com.example.springkpi.lab2.controllers;

import com.example.springkpi.lab2.models.Currency;
import com.example.springkpi.lab2.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/currencies")
public class CurrencyController {
    CurrencyService service;
    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public String listCurrencies(Model model) {
        model.addAttribute("currencies", service.getAllCurrencies());
        return "currencies";
    }

    @GetMapping("/add")
    public String addCurrencyForm(Model model) {
        model.addAttribute("currency", new Currency());
        return "addCurrency";
    }

    @PostMapping("/add")
    public String addCurrency(@ModelAttribute Currency currency, @RequestParam String role) {
        if("admin".equalsIgnoreCase(role)) {
            service.addCurrency(currency);
        }
        return "redirect:/currencies";
    }


}
