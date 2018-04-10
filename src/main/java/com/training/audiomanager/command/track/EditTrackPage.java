package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.service.PerformerService;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;
import com.training.audiomanager.util.ParameterConstants;

import javax.servlet.http.HttpServletRequest;

public class EditTrackPage implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;
    private PerformerService performerService;

    public EditTrackPage(MusicTrackService musicTrackService, GenreService genreService, PerformerService performerService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
        this.performerService = performerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter(ParameterConstants.ID));
        request.setAttribute(AttributeConstants.TRACK, musicTrackService.get(id));
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        request.setAttribute(AttributeConstants.PERFORMERS, performerService.getAll());
        return PageConstants.EDIT_TRACK_PAGE;
    }
}
