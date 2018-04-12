package com.training.audiomanager.dao.impl;

import com.training.audiomanager.dao.PerformerDao;
import com.training.audiomanager.dao.queries.PerformerDaoQueries;
import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import com.training.audiomanager.util.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerformerDaoImpl implements PerformerDao {


    @Override
    public List<Performer> getAll() {
        List<Performer> performers = new ArrayList<>();
        String query = PerformerDaoQueries.SELECT_ALL_PERFORMERS;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                performers.add(new PerformerBuilder().buildId(resultSet.getLong(1))
                        .buildName(resultSet.getString(2)).buildPerformer());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performers;
    }

    @Override
    public void add(Performer performer) {
        String query = PerformerDaoQueries.ADD_PERFORMER;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, performer.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Performer get(Long id) {
        Performer performer = null;
        String query = PerformerDaoQueries.GET_PERFORMER_BY_ID;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    performer = new PerformerBuilder().buildId(resultSet.getLong(1)).
                            buildName(resultSet.getString(2)).buildPerformer();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performer;
    }

    @Override
    public Performer get(String name) {
        Performer performer = null;
        String query = PerformerDaoQueries.GET_PERFORMER_BY_NAME;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    performer = new PerformerBuilder().buildId(resultSet.getLong(1)).
                            buildName(resultSet.getString(2)).buildPerformer();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return performer;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void edit(Performer performer) {
        String query = PerformerDaoQueries.EDIT_PERFORMER;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, performer.getName());
            preparedStatement.setLong(2, performer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = PerformerDaoQueries.REMOVE_PERFORMER;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Performer getOrAdd(String name) {
        for (Performer performer : getAll()) {
            if (performer.getName().equals(name)) {
                return performer;
            }
        }
        Performer performer = new PerformerBuilder().buildName(name).buildPerformer();
        add(performer);
        return get(name);
    }
}
