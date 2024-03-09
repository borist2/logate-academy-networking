package com.example.networkingcourse.controllers;

import com.example.networkingcourse.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/form")
    public String greetingSubmit()
    {
        return "greetingSubmit";
    }

    @PostMapping
    public String greetingSubmited(@RequestParam String name, RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("name", name);
        return "redirect:/greetings/submitted"; // Redirect to prevent duplicate submissions
    }

    @GetMapping("/submitted")
    public String greetingSubmited()
    {
        return "greetingSubmited";
    }

    @GetMapping("/userData")
    public String greetingUserData()
    {
        return "greetingUserDataForm";
    }

    @PostMapping("submit/userdata")
    public String greetingUserData(@ModelAttribute UserData userData, RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("userData", userData);
        return "redirect:/greetings/submitted/userdata"; // Redirect to prevent duplicate submissions
    }

    @GetMapping("/submitted/userdata")
    public String greetingSubmittedUserData()
    {
        return "greetingSubmitedUserData";
    }

    @GetMapping("/edit")
    public String editUserDataForm(Model model)
    {
        var userData = new UserData("Test 1", "test1@test.com");
        model.addAttribute("userData", userData);
        return "greetingEditUserDataForm";
    }

    @PutMapping("/edit")
    public String editUserData(@ModelAttribute UserData userData, RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("userData", userData);
        return "redirect:/greetings/submitted/userdata"; // Redirect to prevent duplicate submissions
    }

}
