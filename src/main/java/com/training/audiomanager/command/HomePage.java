package com.training.audiomanager.command;

import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackServiceImpl;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class HomePage implements Command {

    private MusicTrackServiceImpl musicTrackServiceImpl;
    private GenreService genreService;

    public HomePage(MusicTrackServiceImpl musicTrackServiceImpl, GenreService genreService) {
        this.musicTrackServiceImpl = musicTrackServiceImpl;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeConstants.TRACKS, musicTrackServiceImpl.getAll());
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        return PageConstants.INDEX;
    }
}
