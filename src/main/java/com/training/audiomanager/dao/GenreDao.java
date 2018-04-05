package com.training.audiomanager.dao;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenreDao{

    private HashMap<Long, Genre> genreHashMap = new HashMap<>();
    private Long lastId = 1L;

    public List<Genre> getAll() {
        return new ArrayList<>(genreHashMap.values());
    }

    public Genre get(Long id) {
        return genreHashMap.get(id);
    }

    public void add(Genre genre) {
        genre.setId(lastId);
        genreHashMap.put(lastId, genre);
        ++lastId;
    }

    public void remove(Long id) {
        genreHashMap.remove(id);
    }

}
