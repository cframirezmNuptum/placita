package com.laplacitacolombiana.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "¡La Placita Colombiana API está funcionando correctamente!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK - Servicio funcionando";
    }

    @GetMapping("/public/test")
    public String publicTest() {
        return "Endpoint público funcionando";
    }
}