package com.training.audiomanager.service;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import com.training.audiomanager.service.impl.MusicTrackServiceImpl;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertTrue;

@Ignore
public class MusicTrackServiceImplTest {

    private static MusicTrackService musicTrackService;
    private static MusicTrack testTrack;

    @BeforeClass
    public static void init() {
        musicTrackService = new MusicTrackServiceImpl();
        Genre testGenre = new GenreBuilder().buildId(1L).buildName("Test genre").buildGenre();
        Performer testPerformer = new PerformerBuilder().buildId(1L).buildName("Test performer").buildPerformer();
        String album = "Test album";
        testTrack = new MusicTrack(1L, testPerformer, testGenre, album, "Test", 10, LocalDateTime.MAX);
    }

    @Test
    public void addTrackTest() {
        int startSize = musicTrackService.getAll().size();
        musicTrackService.add(testTrack);
        assertTrue(musicTrackService.getAll().size() == startSize + 1);
    }

}
