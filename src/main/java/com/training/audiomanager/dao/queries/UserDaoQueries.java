package com.training.audiomanager.dao.queries;

public interface UserDaoQueries {

    String LOGIN = "SELECT * FROM user AS u " +
            "INNER JOIN role r ON r.id = u.role_id " +
            "WHERE u.name = ? AND u.password = ?";

    String ADD_USER = "INSERT INTO user (name, password, role_id) VALUES (?, ?, ?)";

    String IS_LOGIN_EXISTS = "SELECT id FROM user WHERE name = ?";
}
