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

        List<Contract> returnedContracts = contractsDao.getContractsByRole("Scientist");
        for(Contract c : returnedContracts) {
            System.out.println(c.getTitle());
        }
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

    public List<Contract> listAllContracts() throws SQLException {
        List<Contract> contractList = new ArrayList<>();

        String sql = "SELECT * FROM contracts";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            long user_id = resultSet.getLong("user_id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String country = resultSet.getString("country");
            float reward = resultSet.getFloat("reward");

            Contract contract = new Contract(id, user_id, title, description, country, reward);
            contractList.add(contract);
        }

        resultSet.close();
        statement.close();

        return contractList;
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

    public void deleteContract(long id) {
        try {
            String deleteQuery = "DELETE FROM contracts WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting a new contract.", e);
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

    // SELECT * FROM contracts As c JOIN contracts_roles AS cr ON cr.contract_id = c.id JOIN roles AS r ON cr.role_id = r.id WHERE r.role = "Banker";

    public List<Contract> getContractsByRole(String role) {
        List<Contract> returnContacts = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            String selectQuery = "SELECT *\n" +
                    "FROM contracts AS c\n" +
                    "JOIN contracts_roles AS cr\n" +
                    "ON cr.contract_id = c.id\n" +
                    "JOIN roles AS r\n" +
                    "ON cr.role_id = r.id\n" +
                    "WHERE r.role = ?";
            stmt = connection.prepareStatement(selectQuery);
            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                returnContacts.add(extractContract(rs));
            }
            return returnContacts;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving contracts by role.", e);
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
            rs.getFloat("reward")
        );
    }

    private List<Contract> createContractsFromResults(ResultSet rs) throws SQLException {
        List<Contract> contracts = new ArrayList<>();
        while (rs.next()) {
            contracts.add(extractContract(rs));
        }
        return contracts;
    }


    public boolean updateContract(Contract contract) throws SQLException {
        String sql = "UPDATE contracts SET title = ?, description = ?, country = ?, reward = ?, user_id = ?";
        sql += " WHERE id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, contract.getTitle());
        stmt.setString(2, contract.getDescription());
        stmt.setFloat(3, contract.getReward());
        stmt.setString(4, contract.getCountry());
        stmt.setLong(5, contract.getUserId());

        boolean rowUpdated = stmt.executeUpdate() > 0;
        stmt.close();
        return rowUpdated;
    }

    public boolean deleteContract(Contract contract) throws SQLException {
        String sql = "DELETE FROM contracts WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, contract.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        return rowDeleted;
    }
}
