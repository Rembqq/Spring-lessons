package com.example.springkpi.lab4.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Currency {
    private Long id;
    private String name;
    private String code;
}
