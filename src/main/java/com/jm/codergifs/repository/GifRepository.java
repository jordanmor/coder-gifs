package com.jm.codergifs.repository;

import com.jm.codergifs.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif(1, "code-loop", 1, LocalDate.of(2019,2,13), "Chris Ramacciotti", false),
            new Gif(2, "code-simpsons", 2, LocalDate.of(2019,10,30), "Ben Jakuben", true),
            new Gif(3, "coding-muppets", 3, LocalDate.of(2019,9,15), "Craig Dennis", false),
            new Gif(4, "code-mosh", 1, LocalDate.of(2019,2,13), "Ada Lovelace", true),
            new Gif(5, "cat-coder", 3, LocalDate.of(2019,2,13), "Grace Hopper", false),
            new Gif(6, "code-scroll",2, LocalDate.of(2019,8,23), "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if(gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public Gif findById(int id) {
        for (Gif gif : ALL_GIFS) {
            if(gif.getId() == id) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findAll() {
        return ALL_GIFS;
    }

    public List<Gif> searchByName(String searchString) {
        List<Gif> searchResult = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().contains(searchString)) {
                searchResult.add(gif);
            }
        }
        if(!searchResult.isEmpty()) {
            return searchResult;
        }
        return null;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifsByCategory = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.getCategoryId() == id) {
                gifsByCategory.add(gif);
            }
        }
        if(!gifsByCategory.isEmpty()) {
            return gifsByCategory;
        }
        return null;
    }

    public List<Gif> findFavorites() {
        List<Gif> favorites = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.isFavorite()) {
                favorites.add(gif);
            }
        }
        if(!favorites.isEmpty()) {
            return favorites;
        }
        return null;
    }

    public void toggleFavorite(int id) {
        for(Gif gif : ALL_GIFS) {
            if(gif.getId() == id) {
                gif.setFavorite(!gif.isFavorite());
            }
        }
    }
}
