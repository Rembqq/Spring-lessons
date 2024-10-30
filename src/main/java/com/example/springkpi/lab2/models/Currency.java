package com.example.springkpi.lab2.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Currency {
    private Long id;
    private String name;
}
