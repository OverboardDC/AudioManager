package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.util.InputUtil;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTracksByDuration implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;

    public GetTracksByDuration(MusicTrackService musicTrackService, GenreService genreService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        InputUtil inputUtil = new InputUtil();
        int min = inputUtil.inputIntValue(request, ParameterConstants.MIN);
        int max = inputUtil.inputIntValue(request, ParameterConstants.MAX);
        if (!inputUtil.isValid()) {
            return PageConstants.INDEX_REDIRECT;
        }
        List<MusicTrack> musicTracks = musicTrackService.getTracksByDuration(min, max);
        request.setAttribute(AttributeConstants.TRACKS, musicTracks);
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        return PageConstants.INDEX;
    }
}
