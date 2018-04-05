package com.training.audiomanager.service;

import com.training.audiomanager.dao.MusicTrackDao;
import com.training.audiomanager.entity.MusicTrack;

import java.util.List;

public class MusicTrackService{

    private MusicTrackDao musicTrackDao;
    private Long lastId = 1L;

    public MusicTrackService() {
        musicTrackDao = new MusicTrackDao();
    }

    public List<MusicTrack> getAll() {
        return musicTrackDao.getAll();
    }

    public MusicTrack get(Long id) {
        return musicTrackDao.get(id);
    }

    public void add(MusicTrack musicTrack) {
        musicTrack.setId(lastId);
        musicTrackDao.add(musicTrack);
        ++lastId;
    }

    public void remove(Long id) {
        musicTrackDao.remove(id);
    }

    public List<MusicTrack> getTracksByGenre(Long genreId) {
        return musicTrackDao.getTracksByGenre(genreId);
    }

    public List<MusicTrack> getTracksByPerformer(Long performerId) {
        return musicTrackDao.getTracksByPerformer(performerId);
    }

    public List<MusicTrack> getTracksByDuration(double min, double max) {
        return musicTrackDao.getTracksByDuration(min, max);
    }
}
