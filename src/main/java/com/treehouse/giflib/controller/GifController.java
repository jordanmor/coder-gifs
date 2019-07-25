package com.treehouse.giflib.controller;

import com.treehouse.giflib.model.Gif;
import com.treehouse.giflib.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs() {
        return "home";
    }

    @RequestMapping("/gifs/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
//       Gif gif = new Gif("compiler-bot", LocalDate.of(2019,7,24), "John Doe", true);
       modelMap.put("gif", gifRepository.findByName(name));
       return "gif-details";
    }
}
