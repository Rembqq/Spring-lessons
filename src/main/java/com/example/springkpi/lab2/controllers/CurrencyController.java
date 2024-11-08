//package com.example.springkpi.lab2.controllers;
//
//import com.example.springkpi.lab2.models.Currency;
//import com.example.springkpi.lab2.services.CurrencyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/currencies")
//public class CurrencyController {
//    CurrencyService service;
////    public CurrencyController(CurrencyService service) {
////        this.service = service;
////    }
//    @Autowired
//    public void setService(CurrencyService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public String listCurrencies(Model model) {
//        //System.out.println(service.getAllCurrencies());
//
//        model.addAttribute("currencies", service.getAllCurrencies().values());
//        return "currencies";
//    }
//
//    @GetMapping("/add")
//    public String addCurrencyForm(Model model) {
//        model.addAttribute("currency", new Currency());
//        return "currencies";
//    }
//
//    @PostMapping("/add")
//    public String addCurrency(@ModelAttribute Currency currency, @RequestParam String role) {
//        if("admin".equalsIgnoreCase(role)) {
//            service.addCurrency(currency);
//        }
//        return "redirect:/currencies";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editCurrencyForm(@PathVariable Long id, Model model, @RequestParam String role) {
//        if ("admin".equalsIgnoreCase(role)) {
//            Currency currency = service.getCurrencyById(id);
//            model.addAttribute("currency", currency);
//            return "editCurrency";
//        }
//        return "redirect:/currencies";
//    }
//    @PostMapping("/edit/{id}")
//    public String editCurrency(@PathVariable Long id, @ModelAttribute Currency currency, @RequestParam String role) {
//        if ("admin".equalsIgnoreCase(role)) {
//            currency.setId(id);
//            service.updateCurrency(currency);
//        }
//        return "redirect:/currencies";
//    }
//
//    @PostMapping("/delete/{id}")
//    public String deleteCurrency(@PathVariable Long id, @RequestParam String role) {
//        if("admin".equalsIgnoreCase(role)) {
//            service.deleteCurrency(id);
//        }
//        return "redirect:/currencies";
//    }
//
//}
