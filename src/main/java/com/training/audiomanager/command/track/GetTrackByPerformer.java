package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.service.util.Pagination;
import com.training.audiomanager.util.PaginationUtil;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTrackByPerformer implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;
    private Long lastPerformerId;

    public GetTrackByPerformer(MusicTrackService musicTrackService, GenreService genreService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Pagination pagination = new Pagination();
        int page = PaginationUtil.getPageParameter(request);
        pagination.setPage(page);
        Long performerId = Long.valueOf(request.getParameter(ParameterConstants.ID));
        lastPerformerId = performerId;
        List<MusicTrack> musicTracks = musicTrackService.getTracksByPerformer(performerId, pagination);
        request.setAttribute(AttributeConstants.TRACKS, musicTracks);
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        request.setAttribute(AttributeConstants.PAGES, pagination.getPages());
        request.setAttribute(AttributeConstants.CURRENT_PAGE, page);
        request.setAttribute(AttributeConstants.LAST_PERFORMER_ID, lastPerformerId);
        return PageConstants.INDEX;
    }
}
