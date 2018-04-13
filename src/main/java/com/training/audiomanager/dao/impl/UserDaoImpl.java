package com.training.audiomanager.dao.impl;

import com.training.audiomanager.dao.UserDao;
import com.training.audiomanager.dao.queries.UserDaoQueries;
import com.training.audiomanager.entity.Role;
import com.training.audiomanager.entity.User;
import com.training.audiomanager.entity.builder.RoleBuilder;
import com.training.audiomanager.entity.builder.UserBuilder;
import com.training.audiomanager.util.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//TODO Create user dao
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void add(User user) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserDaoQueries.ADD_USER)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserDaoQueries.LOGIN)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    user = buildUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean isLoginExists(String username) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserDaoQueries.IS_LOGIN_EXISTS)) {
            preparedStatement.setString(1, username);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if(rs.next()){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private User buildUserFromResultSet(ResultSet rs) throws SQLException {
        Role role = new RoleBuilder().
                buildId(rs.getLong("r.id"))
                .buildName(rs.getString("r.name")).buildRole();
        return new UserBuilder().buildId(rs.getLong(1)).buildName(rs.getString(2))
                .buildPassword(rs.getString(3)).buildRole(role).buildUser();
    }
}
