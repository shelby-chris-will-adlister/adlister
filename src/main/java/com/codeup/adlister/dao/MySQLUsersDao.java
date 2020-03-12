package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Config;
import com.mysql.cj.jdbc.Driver;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;
    private static Config config = new Config();

    public static void main(String[] args) {
//        MySQLUsersDao usersDao = new MySQLUsersDao(config);
//
//        System.out.println(usersDao.getUserRole(2));
//
//        User user = usersDao.findByUsername("Brad Pitt");
//        System.out.println(user.getUsername());
//
//        String password = "mm";
//        String hash = BCrypt.hashpw("mm", BCrypt.gensalt());
//        System.out.println(hash);

//        usersDao.insert(new User(3, "test", "test", "test"));

//        usersDao.update(new User(3,10, "test", "test", "testPW"));
    }

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password, role_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setLong(4, user.getRoleId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    public boolean update(User user) {
        String query = "UPDATE users SET email = ?, password = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword());
            stmt.setLong(3, user.getId());
            boolean rowUpdated = stmt.executeUpdate() > 0;
            stmt.close();
            return rowUpdated;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    public String getUserRole(long roleId) {
        String query = "SELECT role FROM roles As r JOIN users AS u ON u.id = r.id WHERE u.id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, roleId);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getLong("role_id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
