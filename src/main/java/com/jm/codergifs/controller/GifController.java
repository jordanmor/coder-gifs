package com.jm.codergifs.controller;

import com.jm.codergifs.repository.CategoryRepository;
import com.jm.codergifs.repository.GifRepository;
import com.jm.codergifs.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GifController {

    @Autowired
    private GifService gifService;

    @GetMapping("/")
    public String listGifs(Model model) {
        model.addAttribute("gifs", gifService.findAll());
        return "gif/index";
    }

    @GetMapping("/gifs/{name}")
    public String gifDetails(@PathVariable String name, Model model) {
        model.addAttribute("gif", gifService.findByName(name));
        return "gif/details";
    }

    @GetMapping("/toggleFavorite")
    public String handleFavorite(@RequestParam("id") long id) {
//        gifService.toggleFavorite(id);
        return "redirect:/";
    }

    @GetMapping("/gifs/toggleFavorite")
    public String handleFavorite(@RequestParam("id") long id, @RequestParam("name") String name) {
//        gifService.toggleFavorite(id);
        return "redirect:/gifs/" + name;
    }
}
