package com.example.springkpi.lessons;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class ColumnFormatter implements Formatter{
    public String format(String[] data) {
        return String.join("\n", data);
    }
}
