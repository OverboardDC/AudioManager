package com.training.audiomanager.service;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertTrue;

public class MusicTrackServiceTest {

    private static MusicTrackService musicTrackService;
    private static MusicTrack testTrack;

    @BeforeClass
    public static void init() {
        musicTrackService = new MusicTrackService();
        Genre testGenre = new GenreBuilder().buildId(1L).buildName("Test genre").buildGenre();
        Performer testPerformer = new PerformerBuilder().buildId(1L).buildName("Test performer").buildPerformer();
        String album = "Test album";
        testTrack = new MusicTrack(1L, testPerformer, testGenre, album, "Test", 1, LocalDateTime.MAX);
    }

    @After
    public void afterTest(){
        musicTrackService = new MusicTrackService();
    }

    @Test
    public void addTrackTest() {
        musicTrackService.add(testTrack);
        assertTrue(musicTrackService.get(1L).equals(testTrack));
    }

    @Test
    public void getAllTracksTest() {
        musicTrackService.add(testTrack);
        assertTrue(musicTrackService.getAll().size() == 1);
    }

    @Test
    public void getTracksByGenreTest() {
        musicTrackService.add(testTrack);
        MusicTrack musicTrack = musicTrackService.getTracksByGenre(1L).get(0);
        assertTrue(musicTrack.getGenre().getId().equals(1L));
    }

    @Test
    public void getTracksByPerformerTest() {
        musicTrackService.add(testTrack);
        MusicTrack musicTrack = musicTrackService.getTracksByPerformer(1L).get(0);
        assertTrue(musicTrack.getPerformer().getId().equals(1L));
    }

    @Test
    public void getTracksByDurationTest() {
        musicTrackService.add(testTrack);
        MusicTrack musicTrack = musicTrackService.getTracksByDuration(0.99, 1.01).get(0);
        assertTrue(musicTrack.equals(testTrack));
    }

    @Test
    public void removeTrackTest() {
        musicTrackService.add(testTrack);
        musicTrackService.remove(1L);
        assertTrue(musicTrackService.getAll().isEmpty());
    }

}
