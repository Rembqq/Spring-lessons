package com.example.springkpi.lab4.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ExchangeRate {
    //private Long id;
    private Currency currency;
    private LocalDate date;
    private BigDecimal rate;
//    public ExchangeRate(Long id, Currency currency, BigDecimal rate, LocalDate date) {
//        this.id = id;
//        this.currency = currency;
//        this.rate = rate;
//        this.date = date;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public Currency getCurrency() { return currency; }
//    public void setCurrency(Currency currency) { this.currency = currency; }
//
//    public BigDecimal getRate() { return rate; }
//    public void setRate(BigDecimal rate) { this.rate = rate; }
//
//    public LocalDate getDate() { return date; }
//    public void setDate(LocalDate date) { this.date = date; }
}
