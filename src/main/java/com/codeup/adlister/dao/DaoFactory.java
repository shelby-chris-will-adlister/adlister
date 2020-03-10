package com.codeup.adlister.dao;
import com.codeup.adlister.util.Config;

public class DaoFactory {
    private static Contracts contractsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Contracts getContractsDao() {
        if (contractsDao == null) {
            contractsDao = new MySQLContractsDao(config);
        }
        return contractsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
