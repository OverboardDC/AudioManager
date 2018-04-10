package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackServiceImpl;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;
import com.training.audiomanager.util.ParameterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTracksByDuration implements Command {

    private MusicTrackServiceImpl musicTrackServiceImpl;
    private GenreService genreService;

    public GetTracksByDuration(MusicTrackServiceImpl musicTrackServiceImpl, GenreService genreService) {
        this.musicTrackServiceImpl = musicTrackServiceImpl;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        int min = Integer.parseInt(request.getParameter(ParameterConstants.MIN));
        int max = Integer.parseInt(request.getParameter(ParameterConstants.MAX));
        List<MusicTrack> musicTracks = musicTrackServiceImpl.getTracksByDuration(min, max);
        request.setAttribute(AttributeConstants.TRACKS, musicTracks);
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        return PageConstants.INDEX;
    }
}
