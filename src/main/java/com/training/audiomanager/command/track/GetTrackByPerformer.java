package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.util.AttributeConstants;
import com.training.audiomanager.util.PageConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTrackByPerformer implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;

    public GetTrackByPerformer(MusicTrackService musicTrackService, GenreService genreService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long performerId = Long.valueOf(request.getParameter("id"));
        List<MusicTrack> musicTracks = musicTrackService.getTracksByPerformer(performerId);
        request.setAttribute(AttributeConstants.TRACKS, musicTracks);
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        return PageConstants.INDEX;
    }
}
