package com.training.audiomanager.dao.constants.queries;

public interface MusicTrackDaoQueries {

    String GET_ALL_TRACKS = "SELECT * FROM musictrack" +
            " INNER JOIN performer p ON musictrack.performer_id = p.id" +
            " INNER JOIN genre g ON musictrack.genre_id = g.id";

    String GET_TRACK = "SELECT * FROM musictrack" +
            " INNER JOIN performer p ON musictrack.performer_id = p.id" +
            " INNER JOIN genre g ON musictrack.genre_id = g.id WHERE musictrack.id = ?";

    String EDIT_TRACK = "UPDATE musictrack SET performer_id = ?, genre_id = ?, album = ?, name = ?, duration = ?  WHERE id = ?";

    String ADD_TRACK = "INSERT INTO musictrack (performer_id, genre_id, album, name, duration, creatingdatetime) VALUES (?,?,?,?,?,?)";

    String REMOVE_TRACK = "DELETE FROM musictrack WHERE id = ?";

    String GET_TRACKS_BY_GENRE = "SELECT * FROM musictrack" +
            " INNER JOIN performer p ON musictrack.performer_id = p.id" +
            " INNER JOIN genre g ON musictrack.genre_id = g.id WHERE g.id = ?";

    String GET_TRACKS_BY_DURATION = "SELECT * FROM musictrack" +
            " INNER JOIN performer p ON musictrack.performer_id = p.id" +
            " INNER JOIN genre g ON musictrack.genre_id = g.id WHERE duration BETWEEN ? AND ?";

    String GET_TRACKS_BY_PERFORMER = "SELECT * FROM musictrack" +
            " INNER JOIN performer p ON musictrack.performer_id = p.id" +
            " INNER JOIN genre g ON musictrack.genre_id = g.id WHERE p.id = ?";

    String GET_COUNT_ALL = "SELECT COUNT(*) from musictrack";
    String GET_COUNT_BY_GENRE = "SELECT COUNT(*) FROM musictrack WHERE genre_id = ?";
    String GET_COUNT_BY_PERFORMER = "SELECT COUNT(*) FROM musictrack WHERE performer_id = ?";
    String GET_COUNT_BY_DURATION = "SELECT COUNT(*) FROM musictrack WHERE duration BETWEEN ? AND ?";
}
