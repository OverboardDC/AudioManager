package com.training.audiomanager.dao.constants.queries;

public interface PerformerDaoQueries {

    String SELECT_ALL_PERFORMERS = "SELECT id, name FROM performer";
    String ADD_PERFORMER = "INSERT INTO performer (name) VALUES (?)";
    String GET_PERFORMER_BY_ID = "SELECT id, name FROM performer WHERE id = ?";
    String GET_PERFORMER_BY_NAME = "SELECT id, name FROM performer WHERE name = ?";
    String EDIT_PERFORMER = "UPDATE performer SET name = ? WHERE id = ?";
    String REMOVE_PERFORMER = "DELETE FROM performer WHERE id = ?";
}
