package com.training.audiomanager.service;

import com.training.audiomanager.entity.MusicTrack;

import java.util.List;

public interface MusicTrackService extends GenericService<MusicTrack>{

    List<MusicTrack> getTracksByGenre(Long genreId);

    List<MusicTrack> getTracksByDuration(int min, int max);

    List<MusicTrack> getTracksByPerformer(Long performerId);
}
