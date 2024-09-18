package com.example.springkpi.lessons;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
//@Primary
public class CaseInsensitiveSorter implements Sorter{
    public void sort(String[] data) {
        Arrays.sort(data, String::compareToIgnoreCase);
    }
}
