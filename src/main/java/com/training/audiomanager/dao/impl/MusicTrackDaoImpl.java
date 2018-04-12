package com.training.audiomanager.dao.impl;

import com.training.audiomanager.dao.MusicTrackDao;
import com.training.audiomanager.dao.queries.MusicTrackDaoQueries;
import com.training.audiomanager.entity.MusicTrack;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.entity.builder.MusicTrackBuilder;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import com.training.audiomanager.util.database.ConnectionFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MusicTrackDaoImpl implements MusicTrackDao {

    @Override
    public List<MusicTrack> getAll() {
        List<MusicTrack> musicTracks = new ArrayList<>();
        String query = MusicTrackDaoQueries.GET_ALL_TRACKS;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                musicTracks.add(buildTrackFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTracks;
    }

    @Override
    public MusicTrack get(Long id) {
        MusicTrack musicTrack = null;
        String query = MusicTrackDaoQueries.GET_TRACK;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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
        String query = MusicTrackDaoQueries.EDIT_TRACK;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

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
        String query = MusicTrackDaoQueries.ADD_TRACK;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

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
        String query = MusicTrackDaoQueries.REMOVE_TRACK;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MusicTrack> getTracksByGenre(Long genreId) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        String query = MusicTrackDaoQueries.GET_TRACKS_BY_GENRE;
        getTracksByField(genreId, musicTracks, query);
        return musicTracks;
    }


    @Override
    public List<MusicTrack> getTracksByDuration(int min, int max) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        String query = MusicTrackDaoQueries.GET_TRACKS_BY_DURATION;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    musicTracks.add(buildTrackFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicTracks;
    }

    @Override
    public List<MusicTrack> getTracksByPerformer(Long performerId) {
        List<MusicTrack> musicTracks = new ArrayList<>();
        String query = MusicTrackDaoQueries.GET_TRACKS_BY_PERFORMER;
        getTracksByField(performerId, musicTracks, query);
        return musicTracks;
    }

    private void getTracksByField(Long fieldId, List<MusicTrack> musicTracks, String query) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, fieldId);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    musicTracks.add(buildTrackFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private MusicTrack buildTrackFromResultSet(ResultSet rs) throws SQLException {
        return new MusicTrackBuilder().buildId(rs.getLong(1)).
                buildPerformer(new PerformerBuilder().buildId(rs.getLong("p.id")).
                        buildName(rs.getString("p.name")).buildPerformer())
                .buildGenre(new GenreBuilder().buildId(rs.getLong("g.id")).
                        buildName(rs.getString("g.name")).buildGenre()).
                        buildAlbum(rs.getString(4)).
                        buildName(rs.getString(5)).
                        buildDuration(rs.getInt(6)).
                        buildCreatingDateTime(LocalDateTime.
                                of(rs.getDate(7).toLocalDate(),
                                        rs.getTime(7).toLocalTime())).buildMusicTrack();
    }

}