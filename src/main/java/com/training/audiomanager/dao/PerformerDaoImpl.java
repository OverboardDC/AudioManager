package com.training.audiomanager.dao;

import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import com.training.audiomanager.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//TODO Create dao instead of temporary map
public class PerformerDaoImpl implements PerformerDao {


    @Override
    public List<Performer> getAll() {
        List<Performer> performers = new ArrayList<>();
        String query = "SELECT id, name FROM performer";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                performers.add(new PerformerBuilder().buildId(resultSet.getLong(1))
                        .buildName(resultSet.getString(2)).buildPerformer());
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return performers;
    }

    @Override
    public void add(Performer performer) {
        String query = "INSERT INTO performer (name) VALUES (?)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, performer.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Performer get(Long id) {
        Performer performer = null;
        String query = "SELECT id, name FROM performer WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    performer = new PerformerBuilder().buildId(resultSet.getLong(1)).
                            buildName(resultSet.getString(2)).buildPerformer();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return performer;
    }

    @Override
    //TODO Refactor
    public Performer get(String name) {
        Performer performer = null;
        String query = "SELECT id, name FROM performer WHERE name = ?";
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    performer = new PerformerBuilder().buildId(resultSet.getLong(1)).
                            buildName(resultSet.getString(2)).buildPerformer();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return performer;
    }

    @Override
    //TODO WAS not tested
    public void edit(Performer performer) {
        String query = "UPDATE performer SET name = ? WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, performer.getName());
            preparedStatement.setLong(2, performer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String query = "DELETE FROM performer WHERE id = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
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
