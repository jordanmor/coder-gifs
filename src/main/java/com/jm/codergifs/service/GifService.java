package com.jm.codergifs.service;

import com.jm.codergifs.model.Gif;
import com.jm.codergifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifService {

    @Autowired
    private GifRepository gifRepository;

    public List<Gif> findAll() {
        return gifRepository.findAll();
    }

    public Gif findById(long id) {
        return gifRepository.findById(id);
    }

    public Gif findByName(String name) {
        return gifRepository.findByName(name);
    }

    public List<Gif> findAllByName(String name) {
        List<Gif> gifs = gifRepository.findAllByNameContaining(name);
        return !gifs.isEmpty() ? gifs : null;
    }

    public List<Gif> findAllByCategoryId(long id) {
        return gifRepository.findAllByCategoryId(id);
    }

    public List<Gif> findAllFavorites(boolean favorite) {
        return gifRepository.findAllByFavoriteEquals(favorite);
    }

    public void save(Gif gif) {
        gifRepository.save(gif);
    }
}
