package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

// @RestController anotacija nurodo, jog Spring tipo rezultatas turetu buti isspausdinamas kleintui toks koks yra
@RestController

// Zymi konfihuracijos komponenta viduje leidzia kurti bean per metodus su @bean anotacija
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping("/skaiciuoti")
    public int skaiciuoti(int num1, int num2, String symbol){
        if(symbol.equals("-")){
            return num1 - num2;
        }
        else if(symbol.equals("*")){
            return num1 * num2;
        }
        else if(symbol.equals("/")){
            return num1 / num2;
        }
        else {
            return num1 + num2;
        }
    }
}
