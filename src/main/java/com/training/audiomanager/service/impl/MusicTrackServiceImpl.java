package com.training.audiomanager.service.impl;

import com.training.audiomanager.dao.impl.MusicTrackDaoImpl;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.service.MusicTrackService;
import com.training.audiomanager.service.util.Pagination;

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
    public List<MusicTrack> getAll(Pagination pagination) {
        return musicTrackDaoImpl.getAll(pagination);
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
    public List<MusicTrack> getTracksByGenre(Long genreId, Pagination pagination) {
        return musicTrackDaoImpl.getTracksByGenre(genreId, pagination);
    }

    @Override
    public List<MusicTrack> getTracksByPerformer(Long performerId, Pagination pagination) {
        return musicTrackDaoImpl.getTracksByPerformer(performerId, pagination);
    }

    @Override
    public List<MusicTrack> getTracksByDuration(int min, int max, Pagination pagination) {
        return musicTrackDaoImpl.getTracksByDuration(min, max, pagination);
    }
}
