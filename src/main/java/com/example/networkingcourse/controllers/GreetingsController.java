package com.example.networkingcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greetings")
public class GreetingsController
{
    @GetMapping
    public String greeting(Model model) {
        model.addAttribute("message", "Hello, Spring MVC");
        return "greeting"; // Name of the view (greeting.html)
    }
}
