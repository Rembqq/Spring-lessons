package com.example.springkpi.lessons;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        /*ConfigurableApplicationContext context = */SpringApplication.run(SpringKpiApplication.class, args);

//        for(String name: context.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }

        //DataProcessor dataProcessor = context.getBean(DataProcessor.class);

//        DataProcessor dataProcessor = new DataProcessor(new CaseInsensitiveSorter(),
//                new ColumnFormatter());

//        String result = dataProcessor.processData(args);
//        System.out.println(result);
    }

    @Bean
    CommandLineRunner runner(DataProcessor dataProcessor) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                String result = dataProcessor.processData(args);
//                System.out.println(result);
//            }
//        };
        return args -> {
            System.out.println(dataProcessor.processData(args));
        };
    }

    @Primary
    @Bean
    CaseInsensitiveSorter caseInsensitiveSorter() {
        return new CaseInsensitiveSorter();
    }

    @Bean
    CaseSensitiveSorter caseSensitiveSorter() {
        return new CaseSensitiveSorter();
    }

    @Primary
    @Bean
    RowFormatter rowFormatter() {
        return new RowFormatter();
    }

    @Bean
    ColumnFormatter columnFormatter() {
        return new ColumnFormatter();
    }

    @Bean
    DataProcessor dataProcessor(Sorter sorter, Formatter formatter) {
        return new DataProcessor(sorter, formatter);
    }

}
