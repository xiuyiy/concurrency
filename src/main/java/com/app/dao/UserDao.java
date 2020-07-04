package com.app.dao;

import com.app.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int saveUser(User user) {
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = null;
        int rows = 0;
        try {


            statement = connection.prepareStatement("insert into user values(?,?,?)");

            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmailAddress());
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
