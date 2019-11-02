package com.example.chatprogram.controller;

import com.example.chatprogram.model.Beskeder;
import com.example.chatprogram.service.BeskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BeskedService beskedService;

    @GetMapping("/")
    public String visForside(Beskeder beskeder, Model model)
    {
        model.addAttribute("beskeder", beskedService.hentAlleChats());
        return "/forside";
    }

    @GetMapping("/nyBesked")
    public String visnyBesked(Beskeder beskeder, Model model)
    {
        model.addAttribute("beskeder", beskeder);
        return "/nyBesked";
    }

    @PostMapping("/sendBesked")
    public String validere(@Valid Beskeder beskeder, BindingResult bindingResult, Model model)
    {


        return "redirect:/";
    }




}
