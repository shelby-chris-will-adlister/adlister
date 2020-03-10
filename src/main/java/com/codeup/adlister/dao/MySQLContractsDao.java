package com.codeup.adlister.dao;
import com.codeup.adlister.util.Config;

import com.codeup.adlister.models.Contract;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContractsDao implements Contracts {
    private Connection connection = null;
    private static Config config = new Config();

    public static void main(String[] args) {
        MySQLContractsDao contractsDao = new MySQLContractsDao(config);

//        System.out.println(contractsDao.getContractRoles(3));

//        contractsDao.insert(new Contract(3, "Test", "Test", "Test", 3.4));

//        List<Contract> allByUser = contractsDao.all(1);
//        for(Contract c : allByUser) {
//            System.out.println(c.getTitle());
//        }
    }

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
            throw new RuntimeException("Error retrieving all contracts.", e);
        }
    }

    public List<Contract> all(long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM contracts WHERE user_id = ?");
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createContractsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all contracts.", e);
        }
    }

    @Override
    public Long insert(Contract contract) {
        try {
            String insertQuery = "INSERT INTO contracts(user_id, title, description, country, reward) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, contract.getUserId());
            stmt.setString(2, contract.getTitle());
            stmt.setString(3, contract.getDescription());
            stmt.setString(4, contract.getCountry());
            stmt.setDouble(5, contract.getReward());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new contract.", e);
        }
    }

    public List<String> getContractRoles(long contactId) {
        ArrayList<String> roles = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            String selectQuery = "SELECT r.role\n" +
                    "FROM roles AS r\n" +
                    "JOIN contracts_roles AS cr\n" +
                    "ON cr.role_id = r.id\n" +
                    "WHERE cr.contract_id = ?";
            stmt = connection.prepareStatement(selectQuery);
            stmt.setLong(1, contactId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                roles.add(rs.getString("role"));
            }
            return roles;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving contract roles.", e);
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
