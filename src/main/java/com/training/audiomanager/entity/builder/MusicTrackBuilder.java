package com.training.audiomanager.entity.builder;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;

import java.time.LocalDateTime;

public class MusicTrackBuilder {

    private MusicTrack musicTrack;

    public MusicTrackBuilder() {
        musicTrack = new MusicTrack();
    }

    public MusicTrackBuilder buildId(Long id){
        musicTrack.setId(id);
        return this;
    }

    public MusicTrackBuilder buildPerformer(Performer performer){
        musicTrack.setPerformer(performer);
        return this;
    }

    public MusicTrackBuilder buildAlbum(String album){
        musicTrack.setAlbum(album);
        return this;
    }

    public MusicTrackBuilder buildGenre(Genre genre){
        musicTrack.setGenre(genre);
        return this;
    }

    public MusicTrackBuilder buildName(String name){
        musicTrack.setName(name);
        return this;
    }

    public MusicTrackBuilder buildDuration(double duration){
        musicTrack.setDuration(duration);
        return this;
    }

    public MusicTrackBuilder buildCreatingDateTime(LocalDateTime creatingDateTime){
        musicTrack.setCreatingDateTime(creatingDateTime);
        return this;
    }

    public MusicTrack buildMusicTrack(){
        return musicTrack;
    }
}
