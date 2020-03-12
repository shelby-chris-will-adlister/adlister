package com.codeup.adlister.dao;

import com.codeup.adlister.models.Contract;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Contracts {
    // get a list of all the ads
    List<Contract> all();
    List<Contract> all(long UserId);
    // insert a new ad and return the new ad's id
    Long insert(Contract ad);
    List<Contract> getContractsByRole(String role);
    void deleteContract(long id);
    boolean updateContract(Contract contract) throws SQLException;
    Contract getContractById(long id);
    void insertNewContractsRoles(long contractId, long roleId);
}
