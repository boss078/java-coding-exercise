package com.boss078.jce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("main")
    public String getMain(Model model){
        return "main-index";
    }
}
