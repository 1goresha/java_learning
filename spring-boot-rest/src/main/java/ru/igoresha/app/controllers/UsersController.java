package ru.igoresha.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.igoresha.app.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @GetMapping("/users")
    public String getHello(ModelMap model){
        User igor = User.builder()
                .first_name("Игорь")
                .last_name("Дерябин")
                .age(30)
                .build();

        User slava = User.builder()
                .first_name("Вячеслав")
                .last_name("Дерябин")
                .age(33)
                .build();

        User stas = User.builder()
                .first_name("Станислав")
                .last_name("Алханов")
                .age(30)
                .build();


        User marsel = User.builder()
                .first_name("Марсель")
                .last_name("Сидиков")
                .age(27)
                .build();

        List<User> users = new ArrayList<>();
        users.add(igor);
        users.add(slava);
        users.add(stas);
        users.add(marsel);

        model.addAttribute("users", users);

        return "hello";
    }
}
