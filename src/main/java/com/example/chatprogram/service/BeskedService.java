package com.example.chatprogram.service;

import com.example.chatprogram.model.Beskeder;
import com.example.chatprogram.repository.BeskedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

/**
 *For at aflaste HomeController er indholdet fra de metoder flyttet til BeskedService.
 * BeskedService modtager værdierne fra HomeController, og retunere hvilken side brugeren skal til.
 *
 */
@Service
public class BeskedService {

    @Autowired
    BeskedRepo beskedRepo;


    //public String visForside(Beskeder beskeder, Model model)
    public List<Beskeder> visForside(Beskeder beskeder)
    {
        List<Beskeder> hentAlleChats = beskedRepo.hentAlleChats();

        //Hvad model.addAtribute er :
        // https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/ui/Model.html
        // https://www.javatpoint.com/spring-mvc-model-interface
        // https://www.thymeleaf.org/doc/articles/springmvcaccessdata.html

        //model.addAttribute("beskeder", hentAlleChats);
        //return "/forside";
        return hentAlleChats;
    }

    public String visnyBesked(Beskeder beskeder, Model model)
    {
        model.addAttribute("beskeder", beskeder);
        return "/nyBesked";
    }

    public String tilfoejBesked(@Valid Beskeder beskeder, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingresult", bindingResult);
            System.out.println("Kommer jeg her?");
            return "/nyBesked";
        }
        beskedRepo.tilfoejBesked(beskeder);
        System.out.println("Eller her?");
        return "redirect:/";
    }
}
