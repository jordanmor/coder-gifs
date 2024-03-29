package com.jm.codergifs.controller;

import com.jm.codergifs.service.CategoryService;
import com.jm.codergifs.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GifService gifService;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/index";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        model.addAttribute("gifs", gifService.findAllByCategoryId(id));
        return "category/details";
    }
}

