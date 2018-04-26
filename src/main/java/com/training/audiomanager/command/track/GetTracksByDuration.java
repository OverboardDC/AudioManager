package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.service.util.Pagination;
import com.training.audiomanager.util.PaginationUtil;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.service.util.InputValidator;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;
import com.training.audiomanager.util.constants.RegexConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTracksByDuration implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;
    private int lastMinDuration;
    private int lastMaxDuration;

    public GetTracksByDuration(MusicTrackService musicTrackService, GenreService genreService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
    }


    public String execute(HttpServletRequest request) {

        InputValidator inputValidator = new InputValidator();
        int min = inputValidator.inputIntValue(request, ParameterConstants.MIN, RegexConstants.NUMBER_REGEX);
        int max = inputValidator.inputIntValue(request, ParameterConstants.MAX, RegexConstants.NUMBER_REGEX);
        if (inputValidator.isValidationFailed()) {
            return PageConstants.INDEX_REDIRECT;
        }
        Pagination pagination = new Pagination();
        int page = PaginationUtil.getPageParameter(request);
        pagination.setPage(page);
        lastMinDuration = min;
        lastMaxDuration = max;
        List<MusicTrack> musicTracks = musicTrackService.getTracksByDuration(min, max, pagination);
        request.setAttribute(AttributeConstants.TRACKS, musicTracks);
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        request.setAttribute(AttributeConstants.PAGES, pagination.getPages());
        request.setAttribute(AttributeConstants.CURRENT_PAGE, page);
        request.setAttribute(AttributeConstants.LAST_MIN_DURATION, lastMinDuration);
        request.setAttribute(AttributeConstants.LAST_MAX_DURATION, lastMaxDuration);
        return PageConstants.INDEX;
    }
}
