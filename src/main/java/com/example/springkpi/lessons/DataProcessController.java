package com.example.springkpi.lessons;

import org.springframework.web.bind.annotation.*;

@RestController //@ResponseBody // no mvc, right to the browser from controller
@RequestMapping("api")
public class DataProcessController {

    private final DataProcessor dataProcessor;

    public DataProcessController(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    @GetMapping("/processData")
    public String processData(String[] data) {
        return dataProcessor.processData(data);
    }

}
