package com.example.springkpi.lessons;

import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Component
public class CaseSensitiveSorter implements Sorter{
    public void sort(String[] data) {
        Arrays.sort(data);
    }

}
