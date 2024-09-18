package com.example.springkpi.lessons;

import org.springframework.stereotype.Component;

//@Component
public class RowFormatter implements Formatter {
    public String format(String[] data) {
        return String.join(" ", data);
    }
}
