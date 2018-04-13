package com.training.audiomanager.command.login;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.util.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class LoginPage implements Command {

    private GenreService genreService;

    public LoginPage(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        request.setAttribute("genres", genreService.getAll());
        return PageConstants.LOGIN_PAGE;
    }
}
