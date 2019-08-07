package com.jm.codergifs.controller;

import com.jm.codergifs.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private GifService gifService;

    @GetMapping("/search")
    public String searchGifs(@RequestParam("q") String queryString, Model model) {
        model.addAttribute("gifs", gifService.findAllByName(queryString));
        return "search";
    }
}
