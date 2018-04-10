package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.MusicTrackBuilder;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackServiceImpl;
import com.training.audiomanager.service.PerformerServiceImpl;
import com.training.audiomanager.util.InputUtil;
import com.training.audiomanager.util.PageConstants;
import com.training.audiomanager.util.ParameterConstants;
import com.training.audiomanager.util.RegexConstants;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class AddTrack implements Command {

    private MusicTrackServiceImpl musicTrackServiceImpl;
    private GenreService genreService;
    private PerformerServiceImpl performerServiceImpl;


    public AddTrack(MusicTrackServiceImpl musicTrackServiceImpl, GenreService genreService, PerformerServiceImpl performerServiceImpl) {
        this.musicTrackServiceImpl = musicTrackServiceImpl;
        this.genreService = genreService;
        this.performerServiceImpl = performerServiceImpl;
    }

    @Override
    public String execute(HttpServletRequest request) {
        InputUtil inputUtil = new InputUtil();
        String performerName = inputUtil.inputStringValue(request, ParameterConstants.PERFORMER, RegexConstants.NAME_REGEX);
        Long genreId = inputUtil.inputLongValue(request, ParameterConstants.GENRE_ID);
        String album = inputUtil.inputStringValue(request, ParameterConstants.ALBUM, RegexConstants.NAME_REGEX);
        String name = inputUtil.inputStringValue(request, ParameterConstants.NAME, RegexConstants.NAME_REGEX);
        int duration = inputUtil.inputIntValue(request, ParameterConstants.DURATION);
        if (!inputUtil.isValid()) {
            return PageConstants.ADD_TRACK_PAGE_REDIRECT;
        }

        Performer performer = performerServiceImpl.getOrAdd(performerName);
        Genre genre = genreService.get(genreId);
        MusicTrack musicTrack = new MusicTrackBuilder().buildPerformer(performer).buildGenre(genre).buildAlbum(album).
                buildName(name).buildDuration(duration).buildCreatingDateTime(LocalDateTime.now()).buildMusicTrack();
        musicTrackServiceImpl.add(musicTrack);
        return PageConstants.INDEX_REDIRECT;
    }

}
