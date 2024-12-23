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
}
