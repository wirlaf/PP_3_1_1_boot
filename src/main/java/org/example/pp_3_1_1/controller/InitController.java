package org.example.pp_3_1_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {

    @GetMapping(value = "/")
    public String init() {
        return "redirect:/users";
    }
}