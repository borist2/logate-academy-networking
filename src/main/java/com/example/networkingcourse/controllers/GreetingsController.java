package com.example.networkingcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/greetings")
public class GreetingsController
{
    @GetMapping
    public String greeting(@RequestParam(value = "message", required = false) String requestMessage, Model model)
    {
        var message = Optional.ofNullable(requestMessage)
                .map(m -> "Custom message: " + m).orElse("Hello world.");
        model.addAttribute("message", message);
        return "greeting"; // Name of the view (greeting.html)
    }

    @GetMapping("/unsafe")
    public String greetingUnsafe(@RequestParam String message, Model model)
    {
        model.addAttribute("message", "Message " + message);
        return "greetingWithoutEscape"; // Name of the view (greeting.html)
    }
}
