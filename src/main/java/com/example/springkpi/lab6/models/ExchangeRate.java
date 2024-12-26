package com.example.springkpi.lab6.models;

import com.example.springkpi.lab6.models.Currency;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "exchange_rates", uniqueConstraints = @UniqueConstraint(columnNames = {"currency_id", "date"}))
@Data
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "ExchangeRate.findByDate", query = "SELECT e FROM ExchangeRate e WHERE e.date = :date"),
        @NamedQuery(name = "ExchangeRate.findByCurrencyAndDateRange",
                query = "SELECT e FROM ExchangeRate e WHERE e.currency.code = :code AND e.date BETWEEN :start AND :end")
})
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal rate;
}
