package com.jm.codergifs.controller;

import com.jm.codergifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/search")
    public String searchGifs(@RequestParam("q") String queryString, Model model) {
        model.addAttribute("gifs", gifRepository.searchByName(queryString));
        return "search";
    }
}
