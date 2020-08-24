package ru.igoresha.app.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.igoresha.app.models.User;
import ru.igoresha.app.security.UserDetailsImpl;

@Controller
@RequestMapping(value = "/profile")
@PreAuthorize(value = "isAuthenticated()")
public class ProfileController {

    @GetMapping
    public String getProfile(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "profile";
    }
}
