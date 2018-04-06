package com.training.audiomanager.command.genre;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.util.InputUtil;
import com.training.audiomanager.util.PageConstants;
import com.training.audiomanager.util.ParameterConstants;

import javax.servlet.http.HttpServletRequest;

public class AddGenre implements Command {

    private GenreService genreService;

    public AddGenre(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        InputUtil inputUtil = new InputUtil();

        String genreName = inputUtil.inputStringValue(request, ParameterConstants.GENRE_NAME);
        if(!inputUtil.isValid()){
            return PageConstants.INDEX_REDIRECT;
        }
        Genre genre = new GenreBuilder().buildName(genreName).buildGenre();
        genreService.add(genre);
        return PageConstants.INDEX_REDIRECT;
    }
}
