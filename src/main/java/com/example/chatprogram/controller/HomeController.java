package com.example.chatprogram.controller;

import com.example.chatprogram.model.Beskeder;
import com.example.chatprogram.service.BeskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    BeskedService beskedService;

    @GetMapping("/")
    public String visForside(Beskeder beskeder, Model model)
    {
        model.addAttribute("beskeder", beskedService.hentAlleBeskeder());
        return "forside";
    }

}
