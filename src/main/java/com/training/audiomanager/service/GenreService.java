package com.training.audiomanager.service;

import com.training.audiomanager.dao.GenreDao;
import com.training.audiomanager.entity.Genre;

import java.util.List;

public class GenreService{

    private GenreDao genreDao = new GenreDao();

    public List<Genre> getAll(){
        return genreDao.getAll();
    }

    public Genre get(Long id) {
        return genreDao.get(id);
    }

    public void add(Genre genre){
        genreDao.add(genre);
    }

    public void remove(Long id) {
        genreDao.remove(id);
    }

}
