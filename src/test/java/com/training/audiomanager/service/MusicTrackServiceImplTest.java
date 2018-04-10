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

@Ignore
public class MusicTrackServiceImplTest {

    private static MusicTrackServiceImpl musicTrackServiceImpl;
    private static MusicTrack testTrack;

    @BeforeClass
    public static void init() {
        musicTrackServiceImpl = new MusicTrackServiceImpl();
        Genre testGenre = new GenreBuilder().buildId(1L).buildName("Test genre").buildGenre();
        Performer testPerformer = new PerformerBuilder().buildId(1L).buildName("Test performer").buildPerformer();
        String album = "Test album";
        testTrack = new MusicTrack(1L, testPerformer, testGenre, album, "Test", 10, LocalDateTime.MAX);
    }

    @Test
    public void addTrackTest() {
        int startSize = musicTrackServiceImpl.getAll().size();
        musicTrackServiceImpl.add(testTrack);
        assertTrue(musicTrackServiceImpl.getAll().size() == startSize + 1);
    }

}
