package com.training.audiomanager.dao.impl;

import com.training.audiomanager.dao.GenreDao;
import com.training.audiomanager.dao.constants.queries.GenreDaoQueries;
import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.util.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao{

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        String query = GenreDaoQueries.SELECT_ALL_GENRES;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                genres.add(new GenreBuilder().buildId(resultSet.getLong(1))
                        .buildName(resultSet.getString(2)).buildGenre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    @Override
    public Genre get(Long id) {
        Genre genre = null;
        String query = GenreDaoQueries.GET_GENRE;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    genre = new GenreBuilder().buildId(resultSet.getLong(1)).
                            buildName(resultSet.getString(2)).buildGenre();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void edit(Genre genre) {
        String query = GenreDaoQueries.EDIT_GENRE;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, genre.getName());
            preparedStatement.setLong(2, genre.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Genre genre) {
        String query = GenreDaoQueries.ADD_GENRE;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, genre.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = GenreDaoQueries.REMOVE_GENRE;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
