package ru.kata.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.model.Users;
import ru.kata.spring.service.UsersSERVICE;

@Controller
@RequestMapping("/index")
public class UsersController {

    private final UsersSERVICE userService;

    @Autowired
    public UsersController(UsersSERVICE userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") Users user) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") Users user) {
        userService.add(user);
        return "redirect:/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") Users user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/index";
    }
}