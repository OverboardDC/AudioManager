package com.training.audiomanager.dao;

import com.training.audiomanager.entity.Genre;
import com.training.audiomanager.entity.builder.GenreBuilder;
import com.training.audiomanager.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenreDao implements GenericDao<Genre> {

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        String query = "SELECT id, name FROM genre";
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
        String query = "SELECT id, name FROM genre WHERE id = ?";
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
        String query = "UPDATE genre SET name = ? WHERE id = ?";
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
        String query = "INSERT INTO genre (name) VALUES (?)";
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
        String query = "DELETE FROM genre WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
