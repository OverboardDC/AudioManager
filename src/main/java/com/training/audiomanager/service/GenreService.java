package com.training.audiomanager.service;

import com.training.audiomanager.dao.GenreDao;
import com.training.audiomanager.entity.Genre;

import java.util.List;

public class GenreService implements GenericService<Genre>{

    private GenreDao genreDao = new GenreDao();

    @Override
    public List<Genre> getAll(){
        return genreDao.getAll();
    }

    @Override
    public Genre get(Long id) {
        return genreDao.get(id);
    }

    @Override
    public void edit(Genre genre) {
        genreDao.edit(genre);
    }

    @Override
    public void add(Genre genre){
        genreDao.add(genre);
    }

    @Override
    public void remove(Long id) {
        genreDao.remove(id);
    }

}
