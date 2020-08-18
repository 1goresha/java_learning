package ru.igoresha.app.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class RootController {

    @GetMapping
    public String getRoot(Authentication authentication){
//        return authentication !=null ? "redirect:/profile" : "redirect:/signIn";
        if (authentication != null){
            return "redirect:/profile";
        }
        return "redirect:/signIn";
    }
}
