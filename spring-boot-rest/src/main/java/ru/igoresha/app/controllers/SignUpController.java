package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.forms.SignUpForm;
import ru.igoresha.app.services.SignUpService;

@Controller
@RequestMapping(value = "/signUp")
@PreAuthorize(value = "permitAll()")
public class SignUpController {


    @Autowired
    private SignUpService signUpService;

    @GetMapping
    public String getSignUp(){
        return "signUp";
    }

    @PostMapping
    public String signUp(SignUpForm signUpForm){// Post форма автоматически сконвертируется в SignUpForm объект
        signUpService.signUp(signUpForm);
        return "redirect:/signIn";
    }
}
