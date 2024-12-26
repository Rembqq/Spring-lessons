package com.example.springkpi.lab6.repositories;

import com.example.springkpi.lab6.models.ExchangeRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {
    List<ExchangeRate> findAll();

    List<ExchangeRate> findByDate(LocalDate date);

    @Query("SELECT e FROM ExchangeRate e WHERE e.currency.code = :code AND e.date BETWEEN :start AND :end")
    List<ExchangeRate> findByCurrencyAndDateRange(String code, LocalDate start, LocalDate end);
}