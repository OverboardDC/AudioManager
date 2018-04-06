package com.training.audiomanager.dao;

import com.training.audiomanager.entity.MusicTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MusicTrackDao{

    private HashMap<Long, MusicTrack> musicTrackMap = new HashMap<>();
    private Long lastId = 1L;

    public List<MusicTrack> getAll() {
        return new ArrayList<>(musicTrackMap.values());
    }

    public MusicTrack get(Long id) {
        return musicTrackMap.get(id);
    }

    public void add(MusicTrack musicTrack) {
        musicTrack.setId(lastId);
        musicTrackMap.put(musicTrack.getId(), musicTrack);
        ++lastId;
    }

    public void remove(Long id) {
        musicTrackMap.remove(id);
    }

    public List<MusicTrack> getTracksByGenre(Long genreId) {
        ArrayList<MusicTrack> musicTracks = new ArrayList<>();
        for(MusicTrack musicTrack : musicTrackMap.values()){
            if(musicTrack.getGenre().getId().equals(genreId)){
                musicTracks.add(musicTrack);
            }
        }
        return musicTracks;
    }

    public List<MusicTrack> getTracksByDuration(int min, int max){
        ArrayList<MusicTrack> musicTracks = new ArrayList<>();
        for(MusicTrack musicTrack : musicTrackMap.values()){
            double duration = musicTrack.getDuration();
            if(duration >= min && duration <= max){
                musicTracks.add(musicTrack);
            }
        }
        return musicTracks;
    }

    public List<MusicTrack> getTracksByPerformer(Long performerId){
        ArrayList<MusicTrack> musicTracks = new ArrayList<>();
        for(MusicTrack musicTrack : musicTrackMap.values()){
            if(musicTrack.getPerformer().getId().equals(performerId)){
                musicTracks.add(musicTrack);
            }
        }
        return musicTracks;
    }

}
