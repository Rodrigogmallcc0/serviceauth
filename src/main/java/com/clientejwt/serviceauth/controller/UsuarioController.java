package com.clientejwt.serviceauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UsuarioController {

    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }
}
