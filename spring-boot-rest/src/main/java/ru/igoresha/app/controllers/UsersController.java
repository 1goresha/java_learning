package ru.igoresha.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.models.User;
import ru.igoresha.app.repositories.UsersRepository;
import ru.igoresha.app.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "sort", required = false) Boolean sort,
                           @RequestParam(value = "by", required = false) String by,
                           @RequestParam(value = "desc", required = false) Boolean desc,
                           ModelMap model){

        List<User> users = new ArrayList<>();
        users = this.userService.getUsers(sort, by, desc);
        model.addAttribute("users", users);
        return "users";
    }

//    @GetMapping("/users/search")
//    public String getSearchByKeyWord(@RequestParam("q") String query, ModelMap model){
//        List<User> users = this.usersRepository.findUserByFirstNameContainsIgnoreCase(query);
//        model.addAttribute("users", users);
//        return "users";
//    }

    @GetMapping("/search.json")
    @ResponseBody//ответ уйдет в Json формате
    public List<User> getSearchByKeyWord(@RequestParam("q") String query){
        return this.userService.findByQuery(query);
    }

    @GetMapping("/search")
    public String getLifeSearchPage(){
        return "search";
    }

}
