package com.training.audiomanager.dao.impl;

import com.training.audiomanager.dao.MusicTrackDao;
import com.training.audiomanager.dao.constants.TableNames;
import com.training.audiomanager.dao.constants.queries.MusicTrackDaoQueries;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.entity.builder.MusicTrackBuilder;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import com.training.audiomanager.service.util.Pagination;
import com.training.audiomanager.util.database.ConnectionFactory;
import com.training.audiomanager.util.database.PaginationDaoUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO Refactor
public class MusicTrackDaoImpl implements MusicTrackDao {

    @Override
    public List<MusicTrack> getAll() {
        return null;
    }

    @Override
    public List<MusicTrack> getAll(Pagination pagination) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        Map<String, Genre> uniqueGenres = new HashMap<>();
        Map<String, Performer> uniquePerformers = new HashMap<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection, MusicTrackDaoQueries.GET_COUNT_ALL));

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    PaginationDaoUtil.formQueryWithPagination(MusicTrackDaoQueries.GET_ALL_TRACKS, pagination))) {

                executeAndExtract(musicTracks, uniqueGenres, uniquePerformers, preparedStatement);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTracks;
    }

    @Override
    public MusicTrack get(Long id) {
        MusicTrack musicTrack = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MusicTrackDaoQueries.GET_TRACK)) {
            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    musicTrack = buildTrackFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTrack;
    }

    @Override
    public void edit(MusicTrack musicTrack) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MusicTrackDaoQueries.EDIT_TRACK)) {
            preparedStatement.setLong(1, musicTrack.getPerformer().getId());
            preparedStatement.setLong(2, musicTrack.getGenre().getId());
            preparedStatement.setString(3, musicTrack.getAlbum());
            preparedStatement.setString(4, musicTrack.getName());
            preparedStatement.setInt(5, musicTrack.getDuration());
            preparedStatement.setLong(6, musicTrack.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(MusicTrack musicTrack) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MusicTrackDaoQueries.ADD_TRACK)) {
            preparedStatement.setLong(1, musicTrack.getPerformer().getId());
            preparedStatement.setLong(2, musicTrack.getGenre().getId());
            preparedStatement.setString(3, musicTrack.getAlbum());
            preparedStatement.setString(4, musicTrack.getName());
            preparedStatement.setInt(5, musicTrack.getDuration());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MusicTrackDaoQueries.REMOVE_TRACK)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MusicTrack> getTracksByGenre(Long genreId, Pagination pagination) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        Map<String, Genre> uniqueGenres = new HashMap<>();
        Map<String, Performer> uniquePerformers = new HashMap<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection, MusicTrackDaoQueries.GET_COUNT_BY_GENRE, genreId));

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    PaginationDaoUtil.formQueryWithPagination(MusicTrackDaoQueries.GET_TRACKS_BY_GENRE, pagination))) {

                preparedStatement.setLong(1, genreId);

                executeAndExtract(musicTracks, uniqueGenres, uniquePerformers, preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTracks;
    }


    @Override
    public List<MusicTrack> getTracksByDuration(int min, int max, Pagination pagination) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        Map<String, Genre> uniqueGenres = new HashMap<>();
        Map<String, Performer> uniquePerformers = new HashMap<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection, MusicTrackDaoQueries.GET_COUNT_BY_DURATION, min, max));

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    PaginationDaoUtil.formQueryWithPagination(MusicTrackDaoQueries.GET_TRACKS_BY_DURATION, pagination))) {

                preparedStatement.setInt(1, min);
                preparedStatement.setInt(2, max);
                executeAndExtract(musicTracks, uniqueGenres, uniquePerformers, preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTracks;
    }

    @Override
    public List<MusicTrack> getTracksByPerformer(Long performerId, Pagination pagination) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        Map<String, Genre> uniqueGenres = new HashMap<>();
        Map<String, Performer> uniquePerformers = new HashMap<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection, MusicTrackDaoQueries.GET_COUNT_BY_PERFORMER, performerId));

            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    PaginationDaoUtil.formQueryWithPagination(MusicTrackDaoQueries.GET_TRACKS_BY_PERFORMER, pagination))) {

                preparedStatement.setLong(1, performerId);

                executeAndExtract(musicTracks, uniqueGenres, uniquePerformers, preparedStatement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTracks;
    }

    private void executeAndExtract(List<MusicTrack> musicTracks, Map<String, Genre> uniqueGenres, Map<String, Performer> uniquePerformers, PreparedStatement preparedStatement) throws SQLException {
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                buildUniqueGenre(rs, uniqueGenres);
                buildUniquePerformer(rs, uniquePerformers);
                musicTracks.add(buildTrackFromResultSet(rs, uniqueGenres, uniquePerformers));
            }
        }
    }

    private void buildUniqueGenre(ResultSet rs, Map<String, Genre> uniqueGenres) throws SQLException {
        Genre genre = buildGenreFromResultSet(rs);
        uniqueGenres.putIfAbsent(genre.getName(), genre);
    }

    private void buildUniquePerformer(ResultSet rs, Map<String, Performer> uniquePerformers) throws
            SQLException {
        Performer performer = buildPerformerFromResultSet(rs);
        uniquePerformers.putIfAbsent(performer.getName(), performer);
    }


    private MusicTrackBuilder getTrackBuilder(ResultSet rs) throws SQLException {
        return new MusicTrackBuilder().buildId(rs.getLong(1)).
                buildAlbum(rs.getString(4)).
                buildName(rs.getString(5)).
                buildDuration(rs.getInt(6)).
                buildCreatingDateTime(LocalDateTime.
                        of(rs.getDate(7).toLocalDate(),
                                rs.getTime(7).toLocalTime()));
    }

    private MusicTrack buildTrackFromResultSet(ResultSet rs) throws SQLException {
        return getTrackBuilder(rs).buildGenre(buildGenreFromResultSet(rs))
                .buildPerformer(buildPerformerFromResultSet(rs)).buildMusicTrack();
    }

    private MusicTrack buildTrackFromResultSet(ResultSet
                                                       rs, Map<String, Genre> genreMap, Map<String, Performer> performerMap) throws SQLException {
        return getTrackBuilder(rs).buildGenre(genreMap.get(rs.getString(TableNames.GENRE_NAME)))
                .buildPerformer(performerMap.get(rs.getString(TableNames.PERFORMER_NAME))).buildMusicTrack();

    }

    private Genre buildGenreFromResultSet(ResultSet rs) throws SQLException {
        return new GenreBuilder().buildId(rs.getLong(TableNames.GENRE_ID))
                .buildName(rs.getString(TableNames.GENRE_NAME)).buildGenre();
    }

    private Performer buildPerformerFromResultSet(ResultSet rs) throws SQLException {
        return new PerformerBuilder().buildId(rs.getLong(TableNames.PERFORMER_ID)).
                buildName(rs.getString(TableNames.PERFORMER_NAME)).buildPerformer();
    }

}
