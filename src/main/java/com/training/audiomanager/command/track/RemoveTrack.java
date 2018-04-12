package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;

import javax.servlet.http.HttpServletRequest;


public class RemoveTrack implements Command {

    private MusicTrackService musicTrackService;

    public RemoveTrack(MusicTrackService musicTrackService) {
        this.musicTrackService = musicTrackService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        musicTrackService.remove(Long.valueOf(request.getParameter(ParameterConstants.ID)));
        return PageConstants.INDEX_REDIRECT;
    }
}
