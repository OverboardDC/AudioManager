package com.training.audiomanager.command.login;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.util.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class RegistrationPage implements Command {

    private GenreService genreService;

    public RegistrationPage(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        return PageConstants.REGISTRATION_PAGE;
    }
}
