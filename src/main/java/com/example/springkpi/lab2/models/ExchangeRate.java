package com.example.springkpi.lab2.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ExchangeRate {
    private int id;
    private Currency currency;
    private LocalDate date;
    private BigDecimal rate;
}
