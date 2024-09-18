package com.example.springkpi.lessons;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class DataProcessor {

    Sorter sorter;
    Formatter formatter;

    public DataProcessor(/*@Qualifier("caseSensitiveOrder")*/ Sorter sorter,
                         /*@Qualifier("columnFormatter")*/ Formatter formatter) {
        this.sorter = sorter;
        this.formatter = formatter;
    }

    public String processData(String[] data) {
        sorter.sort(data);
        return formatter.format(data);

    }
}
