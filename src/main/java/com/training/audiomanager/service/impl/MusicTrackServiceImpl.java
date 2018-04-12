package com.training.audiomanager.service.impl;

import com.training.audiomanager.dao.impl.MusicTrackDaoImpl;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.MusicTrackService;

import java.util.List;

public class MusicTrackServiceImpl implements MusicTrackService {

    private MusicTrackDaoImpl musicTrackDaoImpl;

    public MusicTrackServiceImpl() {
        musicTrackDaoImpl = new MusicTrackDaoImpl();
    }

    @Override
    public List<MusicTrack> getAll() {
        return musicTrackDaoImpl.getAll();
    }

    @Override
    public MusicTrack get(Long id) {
        return musicTrackDaoImpl.get(id);
    }

    @Override
    public void edit(MusicTrack musicTrack) {
        musicTrackDaoImpl.edit(musicTrack);
    }

    @Override
    public void add(MusicTrack musicTrack) {
        musicTrackDaoImpl.add(musicTrack);
    }

    @Override
    public void remove(Long id) {
        musicTrackDaoImpl.remove(id);
    }

    @Override
    public List<MusicTrack> getTracksByGenre(Long genreId) {
        return musicTrackDaoImpl.getTracksByGenre(genreId);
    }

    @Override
    public List<MusicTrack> getTracksByPerformer(Long performerId) {
        return musicTrackDaoImpl.getTracksByPerformer(performerId);
    }

    @Override
    public List<MusicTrack> getTracksByDuration(int min, int max) {
        return musicTrackDaoImpl.getTracksByDuration(min, max);
    }
}
