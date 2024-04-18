package com.spring.calculator.controller;

import com.spring.calculator.model.User;
import com.spring.calculator.service.UserService;
import com.spring.calculator.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @GetMapping("/registracija")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new User());
        return "registracija";
    }
    @PostMapping("/registracija")
    public String processRegistrationForm(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registracija";
        } else {
            userService.save(userForm);
            return "redirect:/";
        }
    }
}
