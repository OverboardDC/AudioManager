package com.training.audiomanager.util.database;

import com.training.audiomanager.dao.constants.SqlOperators;
import com.training.audiomanager.dao.constants.Symbols;
import com.training.audiomanager.service.util.Pagination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO REFACTOR!
public class PaginationDaoUtil {

    public static String formQueryWithPagination(String query, Pagination pagination) {
        StringBuilder stringBuilder = new StringBuilder(query);
        stringBuilder.append(Symbols.SPACE);
        stringBuilder.append(SqlOperators.LIMIT);
        stringBuilder.append(Symbols.SPACE);
        stringBuilder.append((pagination.getPage() * pagination.getItemsOnPage()) - pagination.getItemsOnPage());
        stringBuilder.append(Symbols.COMMA);
        stringBuilder.append(pagination.getItemsOnPage());
        return new String(stringBuilder);
    }

    public static int getTotalItemsCount(Connection connection, String query) throws SQLException {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        }
        return count;
    }

    public static int getTotalItemsCount(Connection connection, String query, Long fieldId) throws SQLException {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, fieldId);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        }
        return count;
    }

    public static int getTotalItemsCount(Connection connection, String query, int min, int max) throws SQLException {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, min);
            preparedStatement.setInt(2, max);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        }
        return count;
    }

}
