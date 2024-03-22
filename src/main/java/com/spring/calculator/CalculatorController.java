package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
// @RestController anotacija nurodo, jog Spring tipo rezultatas turetu buti isspausdinamas kleintui toks koks yra
@Controller
// Zymi konfihuracijos komponenta viduje leidzia kurti bean per metodus su @bean anotacija
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String skaiciuotuvas() {
        return "skaiciuotuvas";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/skaiciuoti")
    String skaiciuoti(@RequestParam HashMap<String, String> skaiciai, ModelMap modelMap){
        double num1 = Integer.parseInt(skaiciai.get("sk1"));
        double num2 = Integer.parseInt(skaiciai.get("sk2"));
        String zenklas = skaiciai.get("zenklas");

        if(zenklas.equals("+")){
            modelMap.put("sk1", num1);
            modelMap.put("sk2", num2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", num1+num2);
        }
        else if(zenklas.equals("-")){
            modelMap.put("sk1", num1);
            modelMap.put("sk2", num2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", num1-num2);
        }
        else if(zenklas.equals("/")){
            modelMap.put("sk1", num1);
            modelMap.put("sk2", num2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", num1/num2);
        }
        else if(zenklas.equals("*")){
            modelMap.put("sk1", num1);
            modelMap.put("sk2", num2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", num1*num2);
        }
        else {
            modelMap.put("zenklas", "ERROR");
        }
        return "skaiciuoti";
    }
}
