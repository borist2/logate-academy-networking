package com.example.networkingcourse.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
    @GetMapping
    public String index()
    {
        return "index";
    }


    @GetMapping("restricted")
    @PreAuthorize("hasRole('ADMIN')")
    public String restricted()
    {
        return "restricted";
    }
}
