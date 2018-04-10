package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.PerformerServiceImpl;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class AddTrackPage implements Command{

    private GenreService genreService;
    private PerformerServiceImpl performerServiceImpl;

    public AddTrackPage(GenreService genreService, PerformerServiceImpl performerServiceImpl) {
        this.genreService = genreService;
        this.performerServiceImpl = performerServiceImpl;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        request.setAttribute(AttributeConstants.PERFORMERS, performerServiceImpl.getAll());
        return PageConstants.ADD_TRACK_PAGE;
    }
}
