package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.MusicTrackBuilder;
import com.training.audiomanager.service.*;
import com.training.audiomanager.service.util.InputValidator;
import com.training.audiomanager.util.constants.PageConstants;
import com.training.audiomanager.util.constants.ParameterConstants;
import com.training.audiomanager.util.constants.RegexConstants;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class EditTrack implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;
    private PerformerService performerService;

    public EditTrack(MusicTrackService musicTrackService, GenreService genreService, PerformerService performerService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
        this.performerService = performerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        InputValidator inputValidator = new InputValidator();
        Long musicTrackId = Long.valueOf(request.getParameter(ParameterConstants.ID));
        String performerName = inputValidator.inputStringValue(request, ParameterConstants.PERFORMER, RegexConstants.NAME_REGEX);
        Long genreId = inputValidator.inputLongValue(request, ParameterConstants.GENRE_ID, RegexConstants.NUMBER_REGEX);
        String album = inputValidator.inputStringValue(request, ParameterConstants.ALBUM, RegexConstants.NAME_REGEX);
        String name = inputValidator.inputStringValue(request, ParameterConstants.NAME, RegexConstants.NAME_REGEX);
        int duration = inputValidator.inputIntValue(request, ParameterConstants.DURATION, RegexConstants.NUMBER_REGEX);

        if (inputValidator.isValidationFailed()) {
            return PageConstants.EDIT_TRACK_PAGE_REDIRECT + "?id=" + musicTrackId;
        }

        Performer performer = performerService.getOrAdd(performerName);
        Genre genre = genreService.get(genreId);
        MusicTrack musicTrack = new MusicTrackBuilder().buildId(musicTrackId).buildPerformer(performer).
                buildGenre(genre).buildAlbum(album).buildName(name).buildDuration(duration)
                .buildCreatingDateTime(LocalDateTime.now()).buildMusicTrack();
        musicTrackService.edit(musicTrack);
        return PageConstants.INDEX_REDIRECT;
    }
}
