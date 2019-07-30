package com.tts.giflib.controller;

import com.tts.giflib.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String listGifs(Model model) {
        model.addAttribute("gifs", gifRepository.findAll());
        return "gif/index";
    }

    @GetMapping("/gifs/{name}")
    public String gifDetails(@PathVariable String name, Model model) {
        model.addAttribute("gif", gifRepository.findByName(name));
        return "gif/details";
    }

    @GetMapping("/toggleFavorite")
    public String handleFavorite(@RequestParam("id") int id) {
        gifRepository.toggleFavorite(id);
        return "redirect:/";
    }

    @GetMapping("/gifs/toggleFavorite")
    public String handleFavorite(@RequestParam("id") int id, @RequestParam("name") String name) {
        gifRepository.toggleFavorite(id);
        return "redirect:/gifs/" + name;
    }
}