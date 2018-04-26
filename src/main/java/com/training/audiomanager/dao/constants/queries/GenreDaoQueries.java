package com.training.audiomanager.dao.constants.queries;

public interface GenreDaoQueries {

    String SELECT_ALL_GENRES = "SELECT id, name FROM genre";
    String GET_GENRE = "SELECT id, name FROM genre WHERE id = ?";
    String EDIT_GENRE = "UPDATE genre SET name = ? WHERE id = ?";
    String ADD_GENRE = "INSERT INTO genre (name) VALUES (?)";
    String REMOVE_GENRE = "DELETE FROM genre WHERE id = ?";
}
