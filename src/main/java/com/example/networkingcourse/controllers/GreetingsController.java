package com.example.networkingcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/greetings")
public class GreetingsController
{
    @GetMapping
    public String greeting(@RequestParam("message") String message, Model model)
    {
        model.addAttribute("message", "Custom message: " + message);
        return "greeting"; // Name of the view (greeting.html)
    }
}
