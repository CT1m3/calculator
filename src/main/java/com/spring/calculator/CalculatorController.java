package com.spring.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

// @RestController anotacija nurodo, jog Spring tipo rezultatas turetu buti isspausdinamas kleintui toks koks yra
@RestController

// Zymi konfihuracijos komponenta viduje leidzia kurti bean per metodus su @bean anotacija
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        // ApplicationContext yra interfeisas skirtas suteikti informacija apie aplikacijos konfiguracija
        // Siuo atvejo naudojama konfiguracija paimama is *.xml file
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // bean - atitinka singleton sablona
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloWorld");
        return bean.getHello();
    }
    @GetMapping("/abc")
    public String test(@RequestParam(value = "name", defaultValue = "default value test") String name, String surname, int age){
        return "Skaiciuotuvas <p>" +
                "Galimos operacijos: <br>" +
                "&nbsp;&nbsp; sudeti <br>" +
                "&nbsp;&nbsp; atimti <br>" +
                "&nbsp;&nbsp; dauginti <br>" +
                "&nbsp;&nbsp; dalinti <br><p>" + name + " " + surname + " " + age;
    }
}
