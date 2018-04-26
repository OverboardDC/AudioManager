package com.training.audiomanager.service;

import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.util.Pagination;

import java.util.List;

public interface MusicTrackService extends GenericService<MusicTrack>{

    List<MusicTrack> getAll(Pagination pagination);

    List<MusicTrack> getTracksByGenre(Long genreId, Pagination pagination);

    List<MusicTrack> getTracksByDuration(int min, int max, Pagination pagination);

    List<MusicTrack> getTracksByPerformer(Long performerId, Pagination pagination);
}
