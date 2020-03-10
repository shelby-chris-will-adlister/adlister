package com.codeup.adlister.dao;
import com.codeup.adlister.util.Config;

import com.codeup.adlister.models.Contract;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContractsDao implements Contracts {
    private Connection connection = null;

    public MySQLContractsDao(Config config) {
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
    public List<Contract> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM contracts");
            ResultSet rs = stmt.executeQuery();
            return createContractsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all contacts.", e);
        }
    }

    @Override
    public Long insert(Contract contract) {
        try {
            String insertQuery = "INSERT INTO contracts(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, contract.getUserId());
            stmt.setString(2, contract.getTitle());
            stmt.setString(3, contract.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new contract.", e);
        }
    }

    private Contract extractContract(ResultSet rs) throws SQLException {
        return new Contract(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("country"),
            rs.getDouble("reward")
        );
    }

    private List<Contract> createContractsFromResults(ResultSet rs) throws SQLException {
        List<Contract> contracts = new ArrayList<>();
        while (rs.next()) {
            contracts.add(extractContract(rs));
        }
        return contracts;
    }
}
