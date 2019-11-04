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

    //https://www.tutorialspoint.com/spring/spring_autowired_annotation.htm
    //@Autowired on Properties to get rid of the setter methods (not always a good idea)
    @Autowired
    BeskedService beskedService;

    /**
     * Metoderne i HomeContolleren skal retunere de værdier der kommer fra brugeren til BeskedService.
     * Værdierne kommer fra de forskellige undersider og indtastet beskeder og navn.
     *
     * @param beskeder
     * @param model
     * @return
     */
    @GetMapping("/")
    public String visForside(Beskeder beskeder, Model model)
    {
        return beskedService.visForside(beskeder, model);
    }

    @GetMapping("/nyBesked")
    public String visnyBesked(Beskeder beskeder, Model model)
    {
        return beskedService.visnyBesked(beskeder, model);
    }

    @PostMapping("/sendBesked")
    public String tilfoejBesked(@Valid Beskeder beskeder, BindingResult bindingResult, Model model)
    {
        return beskedService.tilfoejBesked(beskeder, bindingResult, model);
    }




}
