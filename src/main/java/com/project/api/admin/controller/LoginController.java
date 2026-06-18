package com.project.api.admin.controller;

import com.project.api.entities.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/admin/login")
    public String login(Model model){
        model.addAttribute("user" , new UserDto());
        System.out.println("Triggered to -------------------> ");
        return "login";
    }

    @PostMapping("/processLogin")
    public String login2(Model model){
        System.out.println("Triggered to 2-------------------> ");
        return "dashboard";
    }
}
