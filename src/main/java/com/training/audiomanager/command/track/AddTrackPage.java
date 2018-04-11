package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.PerformerService;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class AddTrackPage implements Command{

    private GenreService genreService;
    private PerformerService performerService;

    public AddTrackPage(GenreService genreService, PerformerService performerService) {
        this.genreService = genreService;
        this.performerService = performerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        request.setAttribute(AttributeConstants.PERFORMERS, performerService.getAll());
        return PageConstants.ADD_TRACK_PAGE;
    }
}
