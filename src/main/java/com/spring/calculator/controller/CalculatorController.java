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
    @RequestMapping(method = RequestMethod.GET, value = "/calculator")
    public String home(Model model) {
        model.addAttribute("number", new Number());
        return "calculator";
    }
    @PostMapping("/calculate")
        String calculate(@Valid @ModelAttribute("number") Number e, BindingResult br,
                         @RequestParam HashMap<String, String> numbers, ModelMap modelMap) {
        if(br.hasErrors()) {
            return "calculator";
        } else {

            int num1 = Integer.parseInt(numbers.get("num1"));
            int num2 = Integer.parseInt(numbers.get("num2"));
            String operation = numbers.get("operation");

            double result = 0;

            if (operation.equals("+")) {
                result = num1 + num2;
            } else if (operation.equals("-")) {
                result = num1 - num2;
            } else if (operation.equals("*")) {
                result = num1 * num2;
            } else if (operation.equals("/")) {
                result = (double) num1 / num2;
            }
            modelMap.put("num1", num1);
            modelMap.put("num2", num2);
            modelMap.put("operation", operation);
            modelMap.put("result", result);

            numberService.save(new Number(num1, num2, operation, result));

            return "calculate";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/skaiciai")
    public String getAllNumbers(Model model) {
        model.addAttribute("skaiciai", numberService.getAll());
        return "skaiciai";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/rodyti{id}")
    public String getById(@RequestParam("id") int id, Model model) {
        model.addAttribute("skaicius", numberService.getById(id));
        return "skaicius";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/trinti{id}")
    public String delete(@RequestParam("id") int id, Model model) {
        numberService.delete(id);
        model.addAttribute("skaiciai", numberService.getAll());
        return "skaiciai";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/atnaujinti{id}")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("skaicius", numberService.getById(id));
        return "atnaujinti";
    }
    @PostMapping ("/atnaujintiSkaiciu")
    public String updateNumber(@ModelAttribute("skaicius") Number number) {
        numberService.update(number);
        return "redirect:/rodyti?id=" + number.getId();
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/prisijungti";
    }

}
