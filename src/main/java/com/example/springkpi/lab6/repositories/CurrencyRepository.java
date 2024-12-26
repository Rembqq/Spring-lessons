package com.example.springkpi.lab6.repositories;

import com.example.springkpi.lab6.models.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    List<Currency> findAll();

    Currency findByCode(String code);

    @Query("SELECT c FROM Currency c WHERE c.name = :name")
    List<Currency> findByName(String name);
}

