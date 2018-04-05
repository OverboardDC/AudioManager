package com.training.audiomanager.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class MusicTrack {

    private Long id;
    private Performer performer;
    private Genre genre;
    private String album;
    private String name;
    private double duration;
    private LocalDateTime creatingDateTime;

    public MusicTrack(Long id, Performer performer, Genre genre, String album, String name, double duration, LocalDateTime creatingDateTime) {
        this.id = id;
        this.performer = performer;
        this.genre = genre;
        this.album = album;
        this.name = name;
        this.duration = duration;
        this.creatingDateTime = creatingDateTime;
    }

    public MusicTrack() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDateTime getCreatingDateTime() {
        return creatingDateTime;
    }

    public void setCreatingDateTime(LocalDateTime creatingDateTime) {
        this.creatingDateTime = creatingDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicTrack)) return false;
        MusicTrack that = (MusicTrack) o;
        return Double.compare(that.duration, duration) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(performer, that.performer) &&
                Objects.equals(genre, that.genre) &&
                Objects.equals(album, that.album) &&
                Objects.equals(name, that.name) &&
                Objects.equals(creatingDateTime, that.creatingDateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, performer, genre, album, name, duration, creatingDateTime);
    }
}
