package com.example.springkpi.lab5.dao.impl;

import com.example.springkpi.lab5.dao.ExchangeRateDAO;
import com.example.springkpi.lab5.models.ExchangeRate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ExchangeRateDAOImpl implements ExchangeRateDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long create(ExchangeRate exchangeRate) {
        entityManager.persist(exchangeRate);
        return exchangeRate.getId();
    }

    @Override
    public ExchangeRate read(Long id) {
        return entityManager.find(ExchangeRate.class, id);
    }

    @Override
    public void update(ExchangeRate exchangeRate) {
        entityManager.merge(exchangeRate);
    }

    @Override
    public void deleteById(Long id) {
        ExchangeRate exchangeRate = read(id);
        if (exchangeRate != null) {
            entityManager.remove(exchangeRate);
        }
    }

    @Override
    public List<ExchangeRate> findByDate(LocalDate date) {
        return entityManager.createQuery("SELECT e FROM ExchangeRate e WHERE e.date = :date", ExchangeRate.class)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<ExchangeRate> findByCurrencyAndDateRange(String currencyCode, LocalDate startDate, LocalDate endDate) {
        return entityManager.createQuery(
                        "SELECT e FROM ExchangeRate e WHERE e.currency.code = :code AND e.date BETWEEN :start AND :end", ExchangeRate.class)
                .setParameter("code", currencyCode)
                .setParameter("start", startDate)
                .setParameter("end", endDate)
                .getResultList();
    }
}