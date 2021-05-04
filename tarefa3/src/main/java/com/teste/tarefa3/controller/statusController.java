package com.teste.tarefa3.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class statusController {
    @GetMapping(path="/api/status")
    public java.lang.String check(){
        return "online";
    }
}
