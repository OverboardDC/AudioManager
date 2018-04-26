package com.training.audiomanager.command.genre;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.util.InputValidator;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;
import com.training.audiomanager.util.constants.RegexConstants;

import javax.servlet.http.HttpServletRequest;

public class AddGenre implements Command {

    private GenreService genreService;

    public AddGenre(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        InputValidator inputValidator = new InputValidator();

        String genreName = inputValidator.inputStringValue(request, ParameterConstants.GENRE_NAME, RegexConstants.NAME_REGEX);
        if(inputValidator.isValidationFailed()){
            return PageConstants.INDEX_REDIRECT;
        }
        Genre genre = new GenreBuilder().buildName(genreName).buildGenre();
        genreService.add(genre);
        return PageConstants.INDEX_REDIRECT;
    }
}
