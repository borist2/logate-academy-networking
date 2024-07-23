package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.UserCreateEditDTO;
import com.example.networkingcourse.dto.UserListDTO;
import com.example.networkingcourse.model.QUser;
import com.example.networkingcourse.model.User;
import com.example.networkingcourse.model.projections.UserIdNameProjection;
import com.example.networkingcourse.repository.UserRepository;
import com.example.networkingcourse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController
{
    private final UserRepository userRepository;

    private final UserService userService;

    @GetMapping
    public String userList(Model model, Pageable pageable, @RequestParam("searchName") String searchName)
    {
        var users = userService.listUsers(pageable, searchName);
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/projection")
    public String userListProjection(Model model)
    {
        var users = userRepository.findAllById(1, UserIdNameProjection.class);
//        users.stream().map(user -> new UserListDTO(user.getId(), user.getId() + "_" + user.getName(), "nesto"));

        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/create")
    public String createUserForm()
    {
        return "users/create";
    }

    @PostMapping("/create")
    @Transactional
    public String createUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) throws InterruptedException
    {

        var savedUser = userService.saveUser(user);
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
    public String editUser(@PathVariable Integer id, @ModelAttribute UserCreateEditDTO requestUser, RedirectAttributes redirectAttributes)
    {
//        user.setId(id);
        var user = new User();
        user.setId(id);
        user.setFirstName(requestUser.name());
        user.setEmail(requestUser.email());
        user.setPhone(requestUser.phone());

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
