package com.training.audiomanager.command;

import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class HomePage implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;

    public HomePage(MusicTrackService musicTrackService, GenreService genreService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeConstants.TRACKS, musicTrackService.getAll());
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        return PageConstants.INDEX;
    }
}
