package ru.kata.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.model.Users;
import ru.kata.spring.service.UsersService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private final UsersService userService;

    public UsersController(UsersService userService) {
        this.userService = userService;
    }


    @GetMapping() //list of users //correct
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping("/{id}") //shows user by given id //correct
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "users/user";
    }

    @GetMapping("/new")// adds new user //correct
    public String newUser(@ModelAttribute("user") Users user) {
        return "/users/new";
    }

    @PostMapping() //create new user //correct
    public String create(@ModelAttribute("user") Users user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit") //edit user by his id //correct
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.get(id));
        return "users/edit";
    }

    @PatchMapping("/{id}/edit") //
    public String update(@ModelAttribute("user") @Valid Users user, BindingResult bindingResult,
                         @PathVariable("id") long id) {
        if (bindingResult.hasErrors()){
            return "users/edit";
        }
        userService.update(id);
        return  "redirect:/users";
    }

    @DeleteMapping("/{id}") // correct
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}