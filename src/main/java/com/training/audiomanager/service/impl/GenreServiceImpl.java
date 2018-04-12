package com.training.audiomanager.service.impl;

import com.training.audiomanager.dao.GenreDao;
import com.training.audiomanager.dao.impl.GenreDaoImpl;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.service.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService{

    private GenreDao genreDao = new GenreDaoImpl();

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
