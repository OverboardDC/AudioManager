package com.training.audiomanager.command.track;

import com.training.audiomanager.command.Command;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.MusicTrackBuilder;
import com.training.audiomanager.service.GenreService;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.service.PerformerService;
import com.training.audiomanager.util.InputUtil;
import com.training.audiomanager.util.PageConstants;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class AddTrack implements Command {

    private MusicTrackService musicTrackService;
    private GenreService genreService;
    private PerformerService performerService;


    public AddTrack(MusicTrackService musicTrackService, GenreService genreService, PerformerService performerService) {
        this.musicTrackService = musicTrackService;
        this.genreService = genreService;
        this.performerService = performerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        InputUtil inputUtil = new InputUtil();
        String performerName = inputUtil.inputStringValue(request, "performer");
        Long genreId = inputUtil.inputLongValue(request, "genreId");
        String album = inputUtil.inputStringValue(request, "album");
        String name = inputUtil.inputStringValue(request, "name");
        double duration = inputUtil.inputDoubleValue(request, "duration");
        if (!inputUtil.isValid()) {
            return PageConstants.ADD_TRACK_PAGE_REDIRECT;
        }

        Performer performer = performerService.getOrAdd(performerName);
        Genre genre = genreService.get(genreId);
        MusicTrack musicTrack = new MusicTrackBuilder().buildPerformer(performer).buildGenre(genre).buildAlbum(album).
                buildName(name).buildDuration(duration).buildCreatingDateTime(LocalDateTime.now()).buildMusicTrack();
        musicTrackService.add(musicTrack);
        return PageConstants.INDEX_REDIRECT;
    }

}
