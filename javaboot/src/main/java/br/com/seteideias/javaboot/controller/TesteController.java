package br.com.seteideias.javaboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
}

