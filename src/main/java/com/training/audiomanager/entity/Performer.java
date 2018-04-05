package com.training.audiomanager.entity;

import java.util.Objects;

public class Performer {

    private Long id;
    private String name;

    public Performer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Performer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Performer)) return false;
        Performer performer = (Performer) o;
        return Objects.equals(id, performer.id) &&
                Objects.equals(name, performer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
