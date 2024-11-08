//package com.example.springkpi.lab2.controllers;
//
//import com.example.springkpi.lab2.models.Currency;
//import com.example.springkpi.lab2.models.ExchangeRate;
//import com.example.springkpi.lab2.services.ExchangeRateService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.ui.Model;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//
//@Controller
//@RequestMapping("/rates")
//public class ExchangeRateController {
//    private final ExchangeRateService service;
//
//    public ExchangeRateController(ExchangeRateService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public String getRatesForToday(Model model) {
//        model.addAttribute("rates", service.getExchangeRatesForDate(LocalDate.now()));
//        return "rates";
//    }
//
//    @GetMapping("/currency")
//    public String getRatesByCurrencyAndDateRange(
//            @RequestParam String currencyCode, @RequestParam LocalDate startDate,
//            @RequestParam LocalDate endDate, Model model) {
//        List<ExchangeRate> rates = service.getExchangeRatesByCurrencyAndDateRange(currencyCode, startDate, endDate);
//        model.addAttribute("rates", rates);
//        return "rates";
//    }
//
//    @GetMapping("/addByDayAndCode")
//    public String addCurrencyForm(Model model) {
//        model.addAttribute("exchangeRate", new ExchangeRate());
//        return "currencies";
//    }
//
//    @PostMapping("/addByDayAndCode")
//    public String addByDayAndCode(@ModelAttribute ExchangeRate exchangeRate, @RequestParam String role) {
//        if ("admin".equalsIgnoreCase(role)) {
//            service.addByDateAndCode(exchangeRate);
//        }
//        return "redirect:/rates/currency?role=admin&currencyCode=" + exchangeRate.getCurrency().getCode() +
//                "&startDate=" + exchangeRate.getDate() + "&endDate=" + exchangeRate.getDate();
//    }
//
////    @PostMapping("/addByDayAndCode")
////    public String addByDayAndCode(@RequestParam String code, @RequestParam LocalDate date,
////                                  @RequestParam String role, @RequestParam BigDecimal rate, Model model) {
////        if ("admin".equalsIgnoreCase(role)) {
////            List<ExchangeRate> rates = service.getExchangeRatesForDate(date);
////        }
////        return "redirect:/rates/currency?role=admin&currencyCode=" + code +
////                "&startDate=" + date + "&endDate=" + date;
////    }
//
//
//
////    @GetMapping("/addRate")
////    public String addRateForm(Model model) {
////        model.addAttribute("rate", new ExchangeRate());
////        return "rates";
////    }
////
////    @PostMapping("/addRate")
////    public String addRate(@ModelAttribute ExchangeRate rate, @RequestParam String role) {
////        if("admin".equalsIgnoreCase(role)) {
////            service.addExchangeRate(rate);
////        }
////        return "redirect:/rates";
////    }
//
//}
