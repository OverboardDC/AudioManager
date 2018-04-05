package com.training.audiomanager.entity.builder;

import com.training.audiomanager.entity.Genre;

public class GenreBuilder {

    private Genre genre;

    public GenreBuilder() {
        this.genre = new Genre();
    }

    public GenreBuilder buildId(Long id){
        genre.setId(id);
        return this;
    }

    public GenreBuilder buildName(String name){
        genre.setName(name);
        return this;
    }

    public Genre buildGenre(){
        return genre;
    }
}
