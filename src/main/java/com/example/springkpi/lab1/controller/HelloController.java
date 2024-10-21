package com.example.springkpi.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/")
    @ResponseBody
    String helloWorld() {
        return "<header>About me</header>\n" +
                "\n" +
                "<main>\n" +
                "  <p>\n" +
                "    Our humble team contains of me and... only me. My name is Nikita Volkovskyi, nice to meet you ^^\n" +
                "  </p>\n" +
                "\n" +
                    "  <p>I've been studying Java since the first semester, just didn't want to continue learning JS, C++ or Python even though I had a year of experience learning each language.</p>\n" +
                "\n" +
                "   <p>Recently started course on Coursera \"Algorithms\" by Princeton Uni with examples on Java. Seems interesting. Looking forward to learn more info about frameworks</p>\n" +
                "</main>";
    }
}
