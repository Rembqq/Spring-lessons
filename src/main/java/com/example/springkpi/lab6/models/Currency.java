package com.example.springkpi.lab6.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "currencies")
@Data
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Currency.findByCode", query = "SELECT c FROM Currency c WHERE c.code = :code"),
        @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c")
})
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;
}
