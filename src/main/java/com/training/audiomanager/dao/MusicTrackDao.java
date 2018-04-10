package com.training.audiomanager.dao;

import com.training.audiomanager.entity.MusicTrack;

import java.util.List;

public interface MusicTrackDao extends GenericDao<MusicTrack> {

    List<MusicTrack> getTracksByGenre(Long genreId);

    List<MusicTrack> getTracksByDuration(int min, int max);

    List<MusicTrack> getTracksByPerformer(Long performerId);
}
