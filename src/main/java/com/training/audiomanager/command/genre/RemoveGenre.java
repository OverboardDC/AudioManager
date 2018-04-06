package com.training.audiomanager.command.genre;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.util.PageConstants;
import com.training.audiomanager.util.ParameterConstants;

import javax.servlet.http.HttpServletRequest;

public class RemoveGenre implements Command {

    private GenreService genreService;

    public RemoveGenre(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter(ParameterConstants.ID));
        genreService.remove(id);
        return PageConstants.INDEX_REDIRECT;
    }
}
