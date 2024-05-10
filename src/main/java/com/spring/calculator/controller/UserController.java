package com.spring.calculator.controller;

import com.spring.calculator.model.User;
import com.spring.calculator.repositories.UserRepository;
import com.spring.calculator.service.UserService;
import com.spring.calculator.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
//    @PostMapping("/loginUser")
//    public String processLoginForm(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, HttpSession session, Model model) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errorMessage", "Invalid username or password");
//            return "prisijungti"; // Return the login form again with error message
//        } else {
//            // Here you can add your login logic, for example, checking the user credentials against the database
//            User user = userRepository.findByUsername(userForm.getUsername());
//
//            if (user == null || !bCryptPasswordEncoder.matches(userForm.getPassword(), user.getPassword())) {
//                model.addAttribute("errorMessage", "Invalid username or password");
//                return "prisijungti"; // Return the login form again with error message
//            } else {
//                // If login is successful, you can store user information in the session
//                session.setAttribute("loggedInUser", user);
//                return "redirect:/dashboard"; // Redirect to the dashboard or any other page
//            }
//        }
//    }
}
