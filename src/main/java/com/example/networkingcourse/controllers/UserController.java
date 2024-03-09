package com.example.networkingcourse.controllers;

import com.example.networkingcourse.model.User;
import com.example.networkingcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController
{
    private final UserRepository userRepository;

    @GetMapping
    public String userList(Model model)
    {
        model.addAttribute("users", userRepository.findAll());
        return "users/list";
    }

    @GetMapping("/create")
    public String createUserForm()
    {
        return "users/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, RedirectAttributes redirectAttributes)
    {
        var savedUser = userRepository.save(user);
        redirectAttributes.addFlashAttribute("savedUser", savedUser);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes)
    {
        var possibleUser = userRepository.findById(id);

        if (possibleUser.isPresent())
        {
            model.addAttribute("user", possibleUser.get());
            return "users/edit";
        }

        redirectAttributes.addFlashAttribute("error", "User with id [" + id + "] not found.");

        return "redirect:/users";
    }

    @PutMapping("/edit/{id}")
    public String editUser(@PathVariable Integer id, @ModelAttribute User user, RedirectAttributes redirectAttributes)
    {
        user.setId(id);
        var savedUser = userRepository.save(user);
        redirectAttributes.addFlashAttribute("editedUser", savedUser);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id, RedirectAttributes redirectAttributes)
    {
        userRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("deletedUser", id);
        return "redirect:/users";
    }

}
