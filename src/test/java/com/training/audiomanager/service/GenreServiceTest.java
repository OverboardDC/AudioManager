package com.training.audiomanager.service;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.service.GenreService;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GenreServiceTest {

    private static GenreService genreService;
    private static Genre testGenre;

    @BeforeClass
    public static void init(){
        genreService = new GenreService();
        testGenre = new GenreBuilder().buildId(1L).buildName("Test genre").buildGenre();
    }

    @After
    //TODO
    public void afterTest(){
        genreService = new GenreService();
    }

    @Test
    public void getAllGenresTest(){
        genreService.add(testGenre);
        assertTrue(genreService.getAll().size() == 1);
    }

    @Test
    public void addGenreTest(){
        genreService.add(testGenre);
        assertTrue(genreService.getAll().get(0).equals(testGenre));
    }

    @Test
    public void removeTrackTest(){
        genreService.add(testGenre);
        genreService.remove(1L);
        assertTrue(genreService.getAll().isEmpty());
    }
}
