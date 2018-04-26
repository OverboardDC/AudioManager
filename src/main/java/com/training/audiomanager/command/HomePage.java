package com.training.audiomanager.command;

import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.service.util.Pagination;
import com.training.audiomanager.util.PaginationUtil;
import com.training.audiomanager.util.constants.AttributeConstants;
import com.training.audiomanager.util.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HomePage implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;

    public HomePage(MusicTrackService musicTrackService, GenreService genreService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Pagination pagination = new Pagination();
        int page = PaginationUtil.getPageParameter(request);
        pagination.setPage(page);
        List<MusicTrack> tracks = musicTrackService.getAll(pagination);
        request.setAttribute(AttributeConstants.TRACKS, tracks);
        request.setAttribute(AttributeConstants.GENRES, genreService.getAll());
        request.setAttribute(AttributeConstants.PAGES, pagination.getPages());
        request.setAttribute(AttributeConstants.CURRENT_PAGE, page);

        return PageConstants.INDEX;
    }
}
