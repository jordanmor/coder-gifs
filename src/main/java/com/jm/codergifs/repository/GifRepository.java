package com.jm.codergifs.repository;

import com.jm.codergifs.model.Gif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GifRepository extends JpaRepository<Gif, Long> {
    Gif findByName(String name);
    List<Gif> findAllByCategoryId(long id);
    List<Gif> findAllByFavoriteEquals(boolean favorite);
}