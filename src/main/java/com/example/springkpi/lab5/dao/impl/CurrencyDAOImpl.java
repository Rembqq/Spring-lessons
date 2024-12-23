package com.example.springkpi.lab5.dao.impl;

import com.example.springkpi.lab5.dao.CurrencyDAO;
import com.example.springkpi.lab5.models.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long create(Currency currency) {
        entityManager.persist(currency);
        return currency.getId();
    }

    @Override
    public Currency read(Long id) {
        return entityManager.find(Currency.class, id);
    }

    @Override
    public void update(Currency currency) {
        entityManager.merge(currency);
    }

    @Override
    public void delete(Long id) {
        Currency currency = read(id);
        if (currency != null) {
            entityManager.remove(currency);
        }
    }

    @Override
    public Currency findByCode(String code) {
        return entityManager.createQuery("SELECT c FROM Currency c WHERE c.code = :code", Currency.class)
                .setParameter("code", code)
                .getSingleResult();
    }

    @Override
    public List<Currency> findAll() {
        return entityManager.createQuery("SELECT c FROM Currency c", Currency.class).getResultList();
    }
}
