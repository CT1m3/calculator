package com.spring.calculator.controller;

import com.spring.calculator.model.Number;
import com.spring.calculator.service.NumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@EnableAutoConfiguration
public class CalculatorController {
    @Autowired
    @Qualifier("NumberService")

    public NumberService numberService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home(Model model) {
        model.addAttribute("number", new Number());
        return "skaiciuotuvas";
    }

    @PostMapping("/skaiciuoti") // PostMapping jeigu raktai nesiskiria
    String skaiciuoti(@Valid @ModelAttribute("number") Number e, BindingResult br, @RequestParam HashMap<String, String> skaiciai, ModelMap modelMap){
        if(br.hasErrors()){
            return "skaiciuotuvas";
        }else{
            int sk1 = Integer.parseInt(skaiciai.get("sk1"));
            int sk2 = Integer.parseInt(skaiciai.get("sk2"));
            String zenklas = skaiciai.get("zenklas");

            int rezultatas = 0;
            if(zenklas.equals("+")) {
                rezultatas = sk1 + sk2;
            }else if(zenklas.equals("-")){
                rezultatas = sk1 - sk2;
            }else if(zenklas.equals("*")){
            rezultatas = sk1 * sk2;
            }else if(zenklas.equals("/")){
                rezultatas = sk1 / sk2;
            }
            modelMap.put("sk1", sk1);
            modelMap.put("sk2", sk2);
            modelMap.put("zenklas", zenklas);
            modelMap.put("rezultatas", rezultatas);

            numberService.save(new Number(sk1, sk2, zenklas, rezultatas));

            return "skaiciuoti";
        }
    }
}
