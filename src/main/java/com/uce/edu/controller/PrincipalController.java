package com.uce.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/uce")
public class PrincipalController {

    @GetMapping("/ver")
    public String mostrarPagina() {
        return "vistaPrincipal";
    }

}

