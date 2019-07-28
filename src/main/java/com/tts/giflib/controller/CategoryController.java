package com.tts.giflib.controller;

import com.tts.giflib.data.CategoryRepository;
import com.tts.giflib.data.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id));
        model.addAttribute("gifs", gifRepository.findByCategoryId(id));
        return "category";
    }
}
