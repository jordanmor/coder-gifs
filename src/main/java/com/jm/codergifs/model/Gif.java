package com.jm.codergifs.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="gifs")
public class Gif {

    @Id // Sets the Id as the Primary Key
    // Allows the Id to be generated by the underlying database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private long categoryId;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;

    public Gif() {
        // non-argument constructor needed for the JPA
    }

    public Gif(String name, long categoryId, LocalDate dateUploaded, String username, boolean favorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.favorite = favorite;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
