package org.example.pp_3_1_1.controller;

import jakarta.validation.Valid;
import org.example.pp_3_1_1.model.User;
import org.example.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import web.model.User;
//import web.service.UserService;

//import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(ModelMap model) {
        model.addAttribute("users", userService.listUsers());
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "/edit";
    }

    @PostMapping("/")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam Long id) {
        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        userService.update(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/")
    public String delete(@RequestParam Long id, Model model) {
        userService.delete(id);
        model.addAttribute("user", userService.listUsers());
        return "redirect:/users";
    }
}
