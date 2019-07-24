package com.treehouse.giflib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifController {

    @RequestMapping("/")
    @ResponseBody
    public String listGifs() {
        return "List of all the GIFs!";
    }

    @RequestMapping("/gif")
    @ResponseBody
    public String showGifDetails() {
        return "Show GIF details";
    }
}
