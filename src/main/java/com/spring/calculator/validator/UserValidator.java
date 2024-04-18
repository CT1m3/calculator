package com.spring.calculator.validator;

import com.spring.calculator.model.User;
import com.spring.calculator.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");

        if (!user.getPassword().matches("^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{5,}$")){
            errors.rejectValue("password", "Regex.userForm.password");
        }

        if (!user.getCnfPassword().equals(user.getPassword())) {
            errors.rejectValue("cnfPassword", "Diff.userForm.cnfPassword");
        }
    }
}
