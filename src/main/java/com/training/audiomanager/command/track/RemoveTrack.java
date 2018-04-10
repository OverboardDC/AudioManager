package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.service.MusicTrackServiceImpl;
import com.training.audiomanager.util.PageConstants;
import com.training.audiomanager.util.ParameterConstants;

import javax.servlet.http.HttpServletRequest;


public class RemoveTrack implements Command {

    private MusicTrackServiceImpl musicTrackServiceImpl;

    public RemoveTrack(MusicTrackServiceImpl musicTrackServiceImpl) {
        this.musicTrackServiceImpl = musicTrackServiceImpl;
    }

    @Override
    public String execute(HttpServletRequest request) {
        musicTrackServiceImpl.remove(Long.valueOf(request.getParameter(ParameterConstants.ID)));
        return PageConstants.INDEX_REDIRECT;
    }
}
