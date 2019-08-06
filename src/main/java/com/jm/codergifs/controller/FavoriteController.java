package com.jm.codergifs.controller;

import com.jm.codergifs.model.Gif;
import com.jm.codergifs.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FavoriteController {

    @Autowired
    private GifService gifService;

    @GetMapping("/favorites")
    public String favorites(Model model) {
        model.addAttribute("gifs", gifService.findAllFavorites(true));
        return "gif/favorites";
    }

    @GetMapping("/toggleFavorite")
    public String toggleFavorite(@RequestParam("id") long id, HttpServletRequest request) {
        Gif gif = gifService.findById(id);
        gif.setFavorite(!gif.isFavorite());
        gifService.save(gif);
        return "redirect:" + request.getHeader("Referer");
    }
}
