package com.jm.codergifs.controller;

import com.jm.codergifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/favorites")
    public String favorites(Model model) {
        model.addAttribute("gifs", gifRepository.findAllByFavoriteEquals(true));
        return "gif/favorites";
    }

    @GetMapping("/favorites/toggleFavorite")
    public String handleFavorite(@RequestParam("id") long id) {
//        gifRepository.toggleFavorite(id);
        return "redirect:/favorites";
    }
}
