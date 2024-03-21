package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// @RestController anotacija nurodo, jog Spring tipo rezultatas turetu buti isspausdinamas kleintui toks koks yra
@RestController
@Controller
// Zymi konfihuracijos komponenta viduje leidzia kurti bean per metodus su @bean anotacija
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String skaiciuotuvas() {
        return "skaiciuotuvas";
    }
}
