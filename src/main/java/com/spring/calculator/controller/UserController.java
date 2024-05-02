package com.spring.calculator.controller;

import com.spring.calculator.model.User;
import com.spring.calculator.repositories.UserRepository;
import com.spring.calculator.service.UserService;
import com.spring.calculator.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserController(@Qualifier("UserService") UserService userService) {
        this.userService = userService;
    }
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
            return "redirect:/prisijungti";
        }
    }
    @GetMapping("/prisijungti")
    public String showLoginForm(Model model){
        model.addAttribute("userForm", new User());
        return "prisijungti";
    }
    @PostMapping("/prisijungti")
    public String processLoginForm(@ModelAttribute("userForm") User userForm, Model model){
        User user = userRepository.findByEmail(userForm.getEmail());
        if(user == null || !user.getPassword().equals(userForm.getPassword())){
            model.addAttribute("errorMessage", "Username or password incorrect");
            return "prisijungti";
        }
        return "redirect:/";
    }
}
