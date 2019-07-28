package com.tts.giflib.controller;

import com.tts.giflib.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoriteController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/favorites")
    public String favorites(Model model) {
        model.addAttribute("gifs", gifRepository.findFavorites());
        return "favorites";
    }
}
