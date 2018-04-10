package com.training.audiomanager.service;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.service.GenreService;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

@Ignore
public class GenreServiceTest {

    private static GenreService genreService;
    private static Genre testGenre;

    @BeforeClass
    public static void init(){
        genreService = new GenreService();
        testGenre = new GenreBuilder().buildId(1L).buildName("Test genre").buildGenre();
    }

    @Test
    public void addGenreTest(){
        int startSize = genreService.getAll().size();
        genreService.add(testGenre);
        assertTrue(genreService.getAll().size() == startSize + 1);
    }


}
